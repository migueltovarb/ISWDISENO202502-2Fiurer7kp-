package com.tuempresa.talleres.dto;

public class InscriptionRequest {
    private Long eventoId;
    private Long participanteId;
    private String tipoInscripcion; // "GRATUITA", "PAGADA"
    private String observaciones;

    // Constructor vacío
    public InscriptionRequest() {
    }

    // Constructor con parámetros
    public InscriptionRequest(Long eventoId, Long participanteId, String tipoInscripcion) {
        this.eventoId = eventoId;
        this.participanteId = participanteId;
        this.tipoInscripcion = tipoInscripcion;
    }

    // Getters y Setters
    public Long getEventoId() {
        return eventoId;
    }

    public void setEventoId(Long eventoId) {
        this.eventoId = eventoId;
    }

    public Long getParticipanteId() {
        return participanteId;
    }

    public void setParticipanteId(Long participanteId) {
        this.participanteId = participanteId;
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

    @Override
    public String toString() {
        return "InscriptionRequest{" +
                "eventoId=" + eventoId +
                ", participanteId=" + participanteId +
                ", tipoInscripcion='" + tipoInscripcion + '\'' +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
}