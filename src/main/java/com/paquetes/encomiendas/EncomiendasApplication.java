
package com.paquetes.encomiendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import javax.swing.*;
import java.awt.*;

@SpringBootApplication

public class EncomiendasApplication {
  public static void main(String[] args) {
    SpringApplication.run(EncomiendasApplication.class, args);
System.out.println("¿El entorno es headless?: " + GraphicsEnvironment.isHeadless());
    // Iniciar la GUI principal
    SwingUtilities.invokeLater(() -> new EncomiendasApplication().mostrarVentanaPrincipal());
  }

  // Método para mostrar la ventana principal
  public void mostrarVentanaPrincipal() {
    JFrame frame = new JFrame("Gestión de Encomiendas");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 200);
    frame.setLayout(new FlowLayout());

    // Botones
    JButton btnGenerarEncomienda = new JButton("Generar Encomienda");
    JButton btnRastrearEncomienda = new JButton("Rastrear Encomienda");

    // Acción para "Generar Encomienda"
    btnGenerarEncomienda.addActionListener(e -> mostrarVentanaGenerar());

    // Acción para "Rastrear Encomienda"
    btnRastrearEncomienda.addActionListener(e -> mostrarVentanaRastrear());

    // Añadir botones al frame
    frame.add(btnGenerarEncomienda);
    frame.add(btnRastrearEncomienda);

    // Mostrar la ventana
    frame.setVisible(true);
  }

  // Método para mostrar la ventana de Generar Encomienda
  public void mostrarVentanaGenerar() {
    JFrame frame = new JFrame("Generar Encomienda");
    frame.setSize(400, 300);
    frame.setLayout(new GridLayout(4, 2));

    JLabel lblNumeroOrden = new JLabel("Número de Orden:");
    JTextField txtNumeroOrden = new JTextField();

    JLabel lblDni = new JLabel("DNI del Receptor:");
    JTextField txtDni = new JTextField();

    JLabel lblApellido = new JLabel("Apellido del Receptor:");
    JTextField txtApellido = new JTextField();

    JButton btnEnviar = new JButton("Enviar");

    btnEnviar.addActionListener(e -> {
      // Aquí conectarías con el servicio para crear la encomienda
      JOptionPane.showMessageDialog(frame, "Encomienda generada correctamente.");
    });

    frame.add(lblNumeroOrden);
    frame.add(txtNumeroOrden);
    frame.add(lblDni);
    frame.add(txtDni);
    frame.add(lblApellido);
    frame.add(txtApellido);
    frame.add(btnEnviar);

    frame.setVisible(true);
  }

  // Método para mostrar la ventana de Rastrear Encomienda
  public void mostrarVentanaRastrear() {
    JFrame frame = new JFrame("Rastrear Encomienda");
    frame.setSize(400, 200);
    frame.setLayout(new GridLayout(3, 2));

    JLabel lblDni = new JLabel("DNI del Receptor:");
    JTextField txtDni = new JTextField();

    JLabel lblApellido = new JLabel("Apellido del Receptor:");
    JTextField txtApellido = new JTextField();

    JButton btnBuscar = new JButton("Buscar");

    btnBuscar.addActionListener(e -> {
      // Aquí conectarías con el servicio para buscar la encomienda
      JOptionPane.showMessageDialog(frame, "Encomienda encontrada: Pendiente.");
    });

    frame.add(lblDni);
    frame.add(txtDni);
    frame.add(lblApellido);
    frame.add(txtApellido);
    frame.add(btnBuscar);

    frame.setVisible(true);
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
