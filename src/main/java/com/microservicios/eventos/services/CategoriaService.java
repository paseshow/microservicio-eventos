package com.microservicios.eventos.services;

import com.microservicios.eventos.entity.Categoria;
import com.microservicios.eventos.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoriaService  {

    public List<Categoria> findAll();
    public Categoria findById(Integer id);
    public void save(Categoria categoria);
    public void delete(Integer categoriaId);
}
