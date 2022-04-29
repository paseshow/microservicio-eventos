package com.microservicios.eventos.controllers;

import com.microservicios.eventos.entity.Categoria;
import com.microservicios.eventos.entity.Escenario;
import com.microservicios.eventos.services.EscenarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/escenario")
public class EscenarioController {

    @Autowired
    private EscenarioService escenarioService;

    @GetMapping
    public ResponseEntity<List<Escenario>> findAll() {
        List<Escenario> escenariosAll = this.escenarioService.findAll();

        if(escenariosAll.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok().body(escenariosAll);
    }

    @GetMapping( path = "/{id}")
    public ResponseEntity<Escenario> findById(@PathVariable("id") Integer id) {
        Escenario escenarioById = this.escenarioService.findById(id);

        return escenarioById != null
                ? ResponseEntity.ok().body(escenarioById)
                : ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<List<Escenario>> update(@RequestBody Escenario escenario) {
        this.escenarioService.save(escenario);

        List<Escenario> listEscenariosUpdate = this.escenarioService.findAll();
        return ResponseEntity.ok().body(listEscenariosUpdate);
    };

    @PostMapping
    public ResponseEntity<List<Escenario>> create(@RequestBody Escenario escenarioNew) {
        this.escenarioService.save(escenarioNew);

        List<Escenario> listEscenariosUpdate = this.escenarioService.findAll();
        return ResponseEntity.ok().body(listEscenariosUpdate);
    };

    @DeleteMapping
    public ResponseEntity<List<Escenario>> deleteById(@RequestBody Map<String, Integer> escenarioDelete) {
        this.escenarioService.deleteById(escenarioDelete.get("id"));

        List<Escenario> listEscenariosUpdate = this.escenarioService.findAll();
        return ResponseEntity.ok().body(listEscenariosUpdate);
    };

}
