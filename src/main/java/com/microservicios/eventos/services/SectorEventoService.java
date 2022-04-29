package com.microservicios.eventos.services;

import com.microservicios.eventos.entity.SectorEvento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SectorEventoService {

    public List<SectorEvento> finAll();
    public SectorEvento finById(Integer id);
    public List<SectorEvento> findByEventoId(Integer idEvento);
    public List<SectorEvento> findByIdIn(List<Integer> ids);
}
