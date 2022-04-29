package com.microservicios.eventos.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "categoria")
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String nombre;
    public String descripcion;
}
