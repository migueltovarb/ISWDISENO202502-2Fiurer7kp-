package com.tuempresa.talleres.dto;

import java.time.LocalDateTime;

public class InscriptionResponse {
    private Long id;
    private Long eventoId;
    private String eventoNombre;
    private Long participanteId;
    private String participanteNombre;
    private String participanteEmail;
    private LocalDateTime fechaInscripcion;
    private String estado; // "PENDIENTE", "CONFIRMADA", "CANCELADA"
    private String tipoInscripcion;
    private String observaciones;
    private String codigoInscripcion;

    // Constructor vacío
    public InscriptionResponse() {
    }

    // Constructor con parámetros
    public InscriptionResponse(Long id, Long eventoId, String eventoNombre, Long participanteId, 
                              String participanteNombre, String estado) {
        this.id = id;
        this.eventoId = eventoId;
        this.eventoNombre = eventoNombre;
        this.participanteId = participanteId;
        this.participanteNombre = participanteNombre;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventoId() {
        return eventoId;
    }

    public void setEventoId(Long eventoId) {
        this.eventoId = eventoId;
    }

    public String getEventoNombre() {
        return eventoNombre;
    }

    public void setEventoNombre(String eventoNombre) {
        this.eventoNombre = eventoNombre;
    }

    public Long getParticipanteId() {
        return participanteId;
    }

    public void setParticipanteId(Long participanteId) {
        this.participanteId = participanteId;
    }

    public String getParticipanteNombre() {
        return participanteNombre;
    }

    public void setParticipanteNombre(String participanteNombre) {
        this.participanteNombre = participanteNombre;
    }

    public String getParticipanteEmail() {
        return participanteEmail;
    }

    public void setParticipanteEmail(String participanteEmail) {
        this.participanteEmail = participanteEmail;
    }

    public LocalDateTime getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDateTime fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoInscripcion() {
        return tipoInscripcion;
    }

    public void setTipoInscripcion(String tipoInscripcion) {
        this.tipoInscripcion = tipoInscripcion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getCodigoInscripcion() {
        return codigoInscripcion;
    }

    public void setCodigoInscripcion(String codigoInscripcion) {
        this.codigoInscripcion = codigoInscripcion;
    }

    @Override
    public String toString() {
        return "InscriptionResponse{" +
                "id=" + id +
                ", eventoId=" + eventoId +
                ", eventoNombre='" + eventoNombre + '\'' +
                ", participanteId=" + participanteId +
                ", participanteNombre='" + participanteNombre + '\'' +
                ", participanteEmail='" + participanteEmail + '\'' +
                ", fechaInscripcion=" + fechaInscripcion +
                ", estado='" + estado + '\'' +
                ", tipoInscripcion='" + tipoInscripcion + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", codigoInscripcion='" + codigoInscripcion + '\'' +
                '}';
    }
}