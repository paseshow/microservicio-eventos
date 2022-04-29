package com.microservicios.eventos.services;

import com.microservicios.eventos.entity.Evento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventoService {

    public List<Evento> findAll();
    public Evento findById(Integer id);
    public List<Evento> findByArchivar(Byte archivar);
}
