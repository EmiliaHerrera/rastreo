
package com.paquetes.encomiendas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "encomiendas")
@Setter
@Getter
@NoArgsConstructor
public class Encomienda {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String numeroOrden;

  @Column(nullable = false)
  private String dniReceptor;

  @Column(nullable = false)
  private String apellidoReceptor;
}
