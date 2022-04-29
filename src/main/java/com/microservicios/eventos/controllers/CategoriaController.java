package com.microservicios.eventos.controllers;

import com.microservicios.eventos.entity.Categoria;
import com.microservicios.eventos.services.CategoriaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/categoria")
@CrossOrigin
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
      List<Categoria> listCategorias = this.categoriaService.findAll();

      if(listCategorias.isEmpty())
          return ResponseEntity.noContent().build();

      return ResponseEntity.ok(listCategorias);
    };

    @GetMapping(path = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable("id") Integer id) {
      Categoria categoriaById = this.categoriaService.findById(id);

      if(categoriaById == null)
          return ResponseEntity.noContent().build();

      return ResponseEntity.ok(categoriaById);
    };


    @PutMapping
    public ResponseEntity<List<Categoria>> update(@RequestBody Categoria categoria) {

        this.categoriaService.save(categoria);

        List<Categoria> listCategoriasUpdate = this.categoriaService.findAll();

        return ResponseEntity.ok().body(listCategoriasUpdate);
    };

    @PostMapping
    public ResponseEntity<List<Categoria>> create(@RequestBody Map<String, String> categoriaBody) {

        Categoria createCategoria = new Categoria();
        createCategoria.setNombre( categoriaBody.get("nombre") );
        createCategoria.setDescripcion( categoriaBody.get("descripcion") );

        this.categoriaService.save(createCategoria);

        List<Categoria> listCategoriasUpdate = this.categoriaService.findAll();

        return ResponseEntity.ok().body(listCategoriasUpdate);
    };

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<List<Categoria>> deletById(@PathVariable("id") Integer id) {
        this.categoriaService.delete(id);
        List<Categoria> listCategoriasUpdate = this.categoriaService.findAll();
        return ResponseEntity.ok().body(listCategoriasUpdate);
    }
}
