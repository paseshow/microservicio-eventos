package com.microservicios.eventos.controllers;

import com.microservicios.eventos.entity.Evento;
import com.microservicios.eventos.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/evento")
@CrossOrigin
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public ResponseEntity<List<Evento>> findAll() {
      List<Evento> listEventos = eventoService.findAll();

      if(listEventos.isEmpty())
          return ResponseEntity.noContent().build();

      return ResponseEntity.ok().body(listEventos);
    };

    @GetMapping(path = "/active")
    public ResponseEntity<List<Evento>> listarEventosActivos() {
        Byte archivar = 0;
        List<Evento> listEvenosActivos = eventoService.findByArchivar(archivar);

        if(listEvenosActivos.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok().body(listEvenosActivos);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Evento> findById(@PathVariable("id") Integer id) {
        Evento eventoById = eventoService.findById(id);

        if(eventoById == null)
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok().body(eventoById);
    }
}
