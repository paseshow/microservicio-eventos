package com.microservicios.eventos.services;

import com.microservicios.eventos.entity.Escenario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EscenarioService {

    public List<Escenario> findAll();
    public Escenario findById(Integer id);
    public void save(Escenario escenario);
    public void deleteById(Integer escenarioId);
}
