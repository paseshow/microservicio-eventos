package com.microservicios.eventos.repository;

import com.microservicios.eventos.entity.Escenario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscenarioRepository extends JpaRepository<Escenario, Integer> {
}
