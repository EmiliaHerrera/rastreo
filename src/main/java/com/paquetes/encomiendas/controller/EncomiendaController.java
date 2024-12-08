
package com.paquetes.encomiendas.controller;

import com.paquetes.encomiendas.model.Encomienda;
import com.paquetes.encomiendas.service.EncomiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/encomiendas")
public class EncomiendaController {

  @Autowired
  private EncomiendaService service;

  // Crear una encomienda
  @PostMapping
  public ResponseEntity<Encomienda> crearEncomienda(@RequestBody Encomienda encomienda) {
    return ResponseEntity.ok(service.crearEncomienda(encomienda));
  }

  // Listar todas las encomiendas locales
  @GetMapping
  public ResponseEntity<List<Encomienda>> listarEncomiendas() {
    return ResponseEntity.ok(service.listarEncomiendas());
  }

  // Buscar una encomienda en la API externa
  @GetMapping("/buscar")
  public ResponseEntity<String> buscarEncomiendaExterna(
      @RequestParam String dni, @RequestParam String apellido) {
    return ResponseEntity.ok(service.buscarEncomiendaExterna(dni, apellido));
  }
}
