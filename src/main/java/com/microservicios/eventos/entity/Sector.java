package com.microservicios.eventos.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "sector")
@Data
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String nombre;
    public String descripcion;
    public Integer cantidadColumnas;
    public Integer cantidadFilas;
    public Boolean campo;
    public Boolean numerado;
    public Boolean campoStream;
    public String color;
    public String linkVideoSector;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ESCENARIO_ID", referencedColumnName = "ID")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public Escenario escenarioId;
    //public Integer escenarioId;
}
