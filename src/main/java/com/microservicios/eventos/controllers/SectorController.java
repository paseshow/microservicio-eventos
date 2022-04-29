package com.microservicios.eventos.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.microservicios.eventos.entity.Sector;
import com.microservicios.eventos.services.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/sector")
@CrossOrigin
public class SectorController {

    @Autowired
    private SectorService sectorService;

    @GetMapping
    public ResponseEntity<List<Sector>> findAll() {
        List<Sector> listSectores = this.sectorService.findAll();

        if(listSectores.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(listSectores);
    };

    @GetMapping(path = "/{id}")
    public ResponseEntity<Sector> findById(@PathVariable("id") Integer id){
        Sector sectorById = this.sectorService.findById(id);

        if(sectorById == null)
            return  ResponseEntity.noContent().build();

        return ResponseEntity.ok(sectorById);
    };

    @GetMapping(path = "/escenario/{escenarioId}")
    public ResponseEntity<List<Sector>> findByEscenarioId(@PathVariable("escenarioId") Integer escenarioId) {
        List<Sector> sectorByEscenarioId = this.sectorService.findByEscenarioIdId(escenarioId);

        return sectorByEscenarioId.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok().body(sectorByEscenarioId);
    };

    @PostMapping
    public ResponseEntity<List<Sector>> createSector(@RequestBody Sector sector, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        this.sectorService.save(sector);

        List<Sector> sectorByEscenarioId = this.sectorService.findByEscenarioIdId(sector.getEscenarioId().getId());
        return ResponseEntity.ok().body(sectorByEscenarioId);
    };

    @PutMapping
    public ResponseEntity<List<Sector>> update(@RequestBody Sector sector, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return ResponseEntity.badRequest().build();

        this.sectorService.save(sector);

        List<Sector> sectorByEscenarioId = this.sectorService.findByEscenarioIdId(sector.getEscenarioId().getId());
        return ResponseEntity.ok().body(sectorByEscenarioId);
    };

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        this.sectorService.deleteById(id);
        return ResponseEntity.ok().build();
    };
}
