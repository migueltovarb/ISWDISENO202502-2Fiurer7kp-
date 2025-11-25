package com.tuempresa.talleres.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String tipo;
    private String modalidad;
    private String sede;
    private String estado;
    private float precio;
    private int capacidad;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private List<Sesion> sesiones;

    // Getters y setters
    // Constructor vacío
    // Constructor con campos si lo necesitas
}