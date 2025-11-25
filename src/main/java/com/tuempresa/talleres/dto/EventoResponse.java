package com.tuempresa.talleres.dto;

import java.time.LocalDateTime;

public class EventoResponse {
    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String lugar;
    private Integer capacidadMaxima;
    private Integer inscritosCount;
    private String estado; // "ACTIVO", "CANCELADO", "COMPLETADO"

    // Constructor vacío
    public EventoResponse() {
    }

    // Constructor con parámetros
    public EventoResponse(Long id, String nombre, String descripcion, LocalDateTime fechaInicio, 
                         LocalDateTime fechaFin, String lugar, Integer capacidadMaxima) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.lugar = lugar;
        this.capacidadMaxima = capacidadMaxima;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Integer getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(Integer capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public Integer getInscritosCount() {
        return inscritosCount;
    }

    public void setInscritosCount(Integer inscritosCount) {
        this.inscritosCount = inscritosCount;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "EventoResponse{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", lugar='" + lugar + '\'' +
                ", capacidadMaxima=" + capacidadMaxima +
                ", inscritosCount=" + inscritosCount +
                ", estado='" + estado + '\'' +
                '}';
    }
}