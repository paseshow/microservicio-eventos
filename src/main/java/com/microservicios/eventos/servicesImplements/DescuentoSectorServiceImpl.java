package com.microservicios.eventos.servicesImplements;

import com.microservicios.eventos.entity.DescuentoSector;
import com.microservicios.eventos.repository.DescuentoSectorRepository;
import com.microservicios.eventos.services.DescuentoSectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescuentoSectorServiceImpl implements DescuentoSectorService {

    @Autowired
    private DescuentoSectorRepository descuentoSectorRepository;

    @Override
    public List<DescuentoSector> findBySectorEventoId(Integer idSectorEvento) {
        return this.descuentoSectorRepository.findBySectorEventoId(idSectorEvento);
    }
}
