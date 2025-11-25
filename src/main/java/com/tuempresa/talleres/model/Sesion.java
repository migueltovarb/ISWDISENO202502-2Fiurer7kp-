package com.tuempresa.talleres.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Sesion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    private int duracion; // minutos
    private String tema;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    // Getters, setters, constructores
}