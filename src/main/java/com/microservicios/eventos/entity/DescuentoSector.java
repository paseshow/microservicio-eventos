package com.microservicios.eventos.entity;

import lombok.Data;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "descuento_sector")
@Data
public class DescuentoSector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descripcion;
    private Double porcentaje;
    private Boolean mostrarWeb;
    private Boolean mostrarPv;
    private Boolean mostrarPredio;
    private Integer limite;
    private Date vigenciaDesde;
    private Date vigenciaHasta;
    private Integer sectorEventoId;
    private Integer tipoCodigoId;

}
