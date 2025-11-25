package com.tuempresa.talleres.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String estado;
    private Date fecha;

    @ManyToOne
    private Participante participante;

    @ManyToOne
    private Evento evento;

    // Getters, setters, constructores
}