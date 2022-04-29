package com.microservicios.eventos.servicesImplements;

import com.microservicios.eventos.entity.SectorEvento;
import com.microservicios.eventos.repository.SectorEventoRepository;
import com.microservicios.eventos.services.SectorEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorEventoServiceImpl implements SectorEventoService {

    @Autowired
    private SectorEventoRepository sectorEventoRepository;

    @Override
    public List<SectorEvento> finAll() {
        return this.sectorEventoRepository.findAll();
    }

    @Override
    public SectorEvento finById(Integer id) {
        return this.sectorEventoRepository.findById(id).orElse(null);
    }

    @Override
    public List<SectorEvento> findByEventoId(Integer idEvento) {
        return this.sectorEventoRepository.findByEventoId(idEvento);
    }

    @Override
    public List<SectorEvento> findByIdIn(List<Integer> ids) {
        return this.sectorEventoRepository.findByIdIn(ids);
    }
}
