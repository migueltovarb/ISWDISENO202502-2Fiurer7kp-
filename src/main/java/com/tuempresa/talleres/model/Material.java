package com.tuempresa.talleres.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String url;
    private Date vigenciaHasta;

    @ManyToOne
    private Evento evento;

    // Getters, setters, constructores
}