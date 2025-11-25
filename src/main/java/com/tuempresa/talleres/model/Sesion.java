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
    private String estado;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "ponente_id")
    private Ponente ponente;

    // Getters, setters, constructores
    public Ponente getPonente() {
        return ponente;
    }

    public void setPonente(Ponente ponente) {
        this.ponente = ponente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}