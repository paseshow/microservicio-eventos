package com.microservicios.eventos.services;

import com.microservicios.eventos.entity.DescuentoSector;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DescuentoSectorService {

    public List<DescuentoSector> findBySectorEventoId(Integer idSectorEvento);
}
