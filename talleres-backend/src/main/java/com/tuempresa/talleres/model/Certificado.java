package com.tuempresa.talleres.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Certificado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigoVerificacion;
    private Date emitido;

    @ManyToOne
    private Participante participante;

    @ManyToOne
    private Evento evento;

    // Getters, setters, constructores
}