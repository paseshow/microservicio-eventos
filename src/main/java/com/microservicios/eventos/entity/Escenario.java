package com.microservicios.eventos.entity;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table (name = "escenario")
@Data
public class Escenario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String nombre;
    public String descripcion;
    public Integer cantidadSectores;
    public Integer capacidad;
    public String direccion;
    public String coordenadas;
}
