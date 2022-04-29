package com.microservicios.eventos.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

@Entity
@Table(name = "evento")
@Data
public class Evento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String nombre;
    public String descripcion;
    public Byte ubicacionAuto;
    public Double devolucion;
    public Byte destacado;
    public Date fechaDestacado;
    public String medioPago;
    public String detalle;
    public Byte archivar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ESCENARIO_ID", referencedColumnName = "ID")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public Escenario escenarioId;
    //public Integer escenarioId;

    @Column(name = "PRODUCTOR_ID")
    public Integer productorId;

   @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORIA_ID", referencedColumnName = "ID")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public Categoria categoriaId;
   //public Integer categoriaId;
}
