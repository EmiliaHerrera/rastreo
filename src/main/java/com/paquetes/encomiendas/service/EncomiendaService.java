
package com.paquetes.encomiendas.service;

import com.paquetes.encomiendas.model.Encomienda;
import com.paquetes.encomiendas.repository.EncomiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.List;

@Service
public class EncomiendaService {

  private static final String API_URL = "http://localhost:8082/api/envios";

  @Autowired
  private EncomiendaRepository repository;

  @Autowired
  private RestTemplate restTemplate;

  // Crear una encomienda y enviarla a la API externa
  public Encomienda crearEncomienda(Encomienda encomienda) {
    // Guardar localmente en la base de datos
    Encomienda savedEncomienda = repository.save(encomienda);

    // Enviar la encomienda a la API externa
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<Encomienda> request = new HttpEntity<>(encomienda, headers);
    restTemplate.postForEntity(API_URL, request, String.class);

    return savedEncomienda;
  }

  // Listar todas las encomiendas guardadas localmente
  public List<Encomienda> listarEncomiendas() {
    return repository.findAll();
  }

  // Buscar encomiendas en la API externa por DNI y Apellido
  public String buscarEncomiendaExterna(String dni, String apellido) {
    String url = API_URL + "/buscar?dni=" + dni + "&apellido=" + apellido;
    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

    return response.getBody();
  }
}
