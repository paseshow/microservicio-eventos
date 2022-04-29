package com.microservicios.eventos.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.text.DateFormat;
import java.util.Date;

@Entity
@Table (name = "sector_evento")
@Data
public class SectorEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SECTOR_ID", referencedColumnName = "ID")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public Sector sectorId;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EVENTO_ID", referencedColumnName = "ID")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public Evento eventoId;*/
    private Integer eventoId;
    private Double precioDecimal;
    private Date fechaFuncion;
    private Date fechaLimite;
    private String descripcion;
    private Double scWeb;
    private Double scPv;
    private Double scPredio;
    private Double scPf;
    private Double fijoWeb;
    private Double fijoPv;
    private Double fijoPredio;
    private Double ventaWeb;
    private Double ventaPv;
    private Double venaPredio;
    private Byte invisible;
    private Integer orden;
    private String etiquetaSector;
}
