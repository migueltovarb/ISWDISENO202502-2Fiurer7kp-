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

    // Se mantienen las notas originales arriba y se añaden implementaciones abajo.

    public Certificado() {
    }

    public Certificado(Long id, String codigoVerificacion, Date emitido, Participante participante, Evento evento) {
        this.id = id;
        this.codigoVerificacion = codigoVerificacion;
        this.emitido = emitido;
        this.participante = participante;
        this.evento = evento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoVerificacion() {
        return codigoVerificacion;
    }

    public void setCodigoVerificacion(String codigoVerificacion) {
        this.codigoVerificacion = codigoVerificacion;
    }

    public Date getEmitido() {
        return emitido;
    }

    public void setEmitido(Date emitido) {
        this.emitido = emitido;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}