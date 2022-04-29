package com.microservicios.eventos.controllers;

import com.microservicios.eventos.entity.SectorEvento;
import com.microservicios.eventos.services.SectorEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "/sectorevento")
public class SectorEventoController {

    @Autowired
    private SectorEventoService sectorEventoService;

    @GetMapping
    public ResponseEntity<List<SectorEvento>> findAll() {
        // REFACTOR PARA NO TRAER TODOS LOS DATOS
      List<SectorEvento> listSectorEventos = this.sectorEventoService.finAll();

      if(listSectorEventos.isEmpty())
          return ResponseEntity.noContent().build();

      return ResponseEntity.ok(listSectorEventos);
    };

    @GetMapping(path = "/{id}")
    public ResponseEntity<SectorEvento> findById(@PathVariable("id") Integer id) {
        SectorEvento sectorEvento = this.sectorEventoService.finById(id);

        if(sectorEvento == null)
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(sectorEvento);
    };

    // BUSCA POR ID EVENTO --------------------------------------------
    @GetMapping(path = "/evento/{idEvento}")
    public ResponseEntity<List<SectorEvento>> findByEventoId(@PathVariable("idEvento") Integer idEvento) {
        List<SectorEvento> listSectorEventosByEvento = this.sectorEventoService.findByEventoId(idEvento);

        if(listSectorEventosByEvento == null)
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(listSectorEventosByEvento);
    };

    @GetMapping(path = "/ids")
    public ResponseEntity<List<SectorEvento>> findByIds(@RequestParam List<Integer> ids){
        //List<String> idsSectoresEventos = ids.split(",");

        if(ids.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        List<SectorEvento> listSectorEventosByIds = sectorEventoService.findByIdIn(ids);

        if(listSectorEventosByIds.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok().body(listSectorEventosByIds);
    }

}
