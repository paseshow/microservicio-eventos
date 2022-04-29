package com.microservicios.eventos.controllers;

import com.microservicios.eventos.entity.DescuentoSector;
import com.microservicios.eventos.services.DescuentoSectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/descuentosector")
@CrossOrigin
public class DescuentoSectorController {

    @Autowired
    private DescuentoSectorService descuentoSectorService;

    @GetMapping(path = "/sectorEvento/{id}")
    public ResponseEntity<List<DescuentoSector>> findBySectorEventoId(@PathVariable("id") Integer id) {
      List<DescuentoSector> descuentoSectorBySectorId = descuentoSectorService.findBySectorEventoId(id);

      if(descuentoSectorBySectorId.isEmpty())
          return ResponseEntity.noContent().build();

      return ResponseEntity.ok(descuentoSectorBySectorId);
    };
}
