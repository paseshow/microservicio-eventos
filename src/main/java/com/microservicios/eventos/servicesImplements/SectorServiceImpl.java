package com.microservicios.eventos.servicesImplements;

import com.microservicios.eventos.entity.Sector;
import com.microservicios.eventos.repository.SectorRepository;
import com.microservicios.eventos.services.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorServiceImpl implements SectorService {

    @Autowired
    private SectorRepository sectorRepository;

    @Override
    public List<Sector> findAll() {
        return this.sectorRepository.findAll();
    }

    @Override
    public Sector findById(Integer id) {
        return this.sectorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Sector> findByEscenarioIdId(Integer escenarioId) {
        return this.sectorRepository.findByEscenarioIdId(escenarioId);
    }

    @Override
    public void save(Sector sector) {
        this.sectorRepository.save(sector);
    }

    @Override
    public void deleteById(Integer sectorId) {
        this.sectorRepository.deleteById(sectorId);
    }
}
