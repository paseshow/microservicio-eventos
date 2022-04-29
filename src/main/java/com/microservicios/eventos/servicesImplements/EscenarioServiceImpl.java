package com.microservicios.eventos.servicesImplements;

import com.microservicios.eventos.entity.Escenario;
import com.microservicios.eventos.repository.EscenarioRepository;
import com.microservicios.eventos.services.EscenarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscenarioServiceImpl implements EscenarioService {

    @Autowired
    private EscenarioRepository escenarioRepository;

    @Override
    public List<Escenario> findAll() {
        return this.escenarioRepository.findAll();
    }

    @Override
    public Escenario findById(Integer id) {
        return this.escenarioRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Escenario escenario) {
        this.escenarioRepository.save(escenario);
    }

    @Override
    public void deleteById(Integer escenarioId) {
        this.escenarioRepository.deleteById(escenarioId);
    }
}
