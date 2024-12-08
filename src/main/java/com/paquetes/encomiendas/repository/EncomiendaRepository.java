
package com.paquetes.encomiendas.repository;

import com.paquetes.encomiendas.model.Encomienda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EncomiendaRepository extends JpaRepository<Encomienda, Long> {
  // No se necesitan métodos adicionales, JPA se encarga de las operaciones
  // básicas
}
