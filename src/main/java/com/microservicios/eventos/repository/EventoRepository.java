package com.microservicios.eventos.repository;

import com.microservicios.eventos.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {

    List<Evento> findByArchivar(Byte archivar);
}
