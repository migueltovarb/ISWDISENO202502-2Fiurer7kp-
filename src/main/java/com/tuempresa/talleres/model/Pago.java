package com.tuempresa.talleres.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float monto;
    private String estado;
    private String referencia;
    private Date fecha;

    @ManyToOne
    private Inscripcion inscripcion;

    // Getters, setters, constructores
}