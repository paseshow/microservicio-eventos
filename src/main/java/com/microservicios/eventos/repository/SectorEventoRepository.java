package com.microservicios.eventos.repository;

import com.microservicios.eventos.entity.SectorEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectorEventoRepository extends JpaRepository<SectorEvento, Integer> {

    public List<SectorEvento> findByEventoId(Integer idEvento);
    public List<SectorEvento> findByIdIn(List<Integer> ids);
}
