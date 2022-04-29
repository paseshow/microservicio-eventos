package com.microservicios.eventos.repository;

import com.microservicios.eventos.entity.DescuentoSector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DescuentoSectorRepository extends JpaRepository<DescuentoSector, Integer> {

    public List<DescuentoSector> findBySectorEventoId(Integer idSectorEvento);
}
