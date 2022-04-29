package com.microservicios.eventos.services;

import com.microservicios.eventos.entity.Sector;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SectorService {

    List<Sector> findAll();
    Sector findById(Integer id);
    List<Sector> findByEscenarioIdId(Integer escenarioId);
    void save(Sector sector);
    void deleteById(Integer sectorId);
}
