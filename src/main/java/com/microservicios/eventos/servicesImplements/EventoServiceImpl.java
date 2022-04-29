package com.microservicios.eventos.servicesImplements;

import com.microservicios.eventos.entity.Evento;
import com.microservicios.eventos.repository.EventoRepository;
import com.microservicios.eventos.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public List<Evento> findAll() {
        return eventoRepository.findAll();
    }

    @Override
    public Evento findById(Integer id) {
        return eventoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Evento> findByArchivar(Byte archivar) {
        return eventoRepository.findByArchivar(archivar);
    }
}
