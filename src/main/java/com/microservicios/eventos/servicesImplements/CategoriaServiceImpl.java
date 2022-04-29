package com.microservicios.eventos.servicesImplements;

import com.microservicios.eventos.entity.Categoria;
import com.microservicios.eventos.repository.CategoriaRepository;
import com.microservicios.eventos.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria findById(Integer id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Categoria categoria) {
        this.categoriaRepository.save(categoria);
    }

    @Override
    public void delete(Integer categoriaId) {
        this.categoriaRepository.deleteById(categoriaId);
    }

}
