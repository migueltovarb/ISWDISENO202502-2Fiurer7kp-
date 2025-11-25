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

    // Se mantienen las notas originales arriba y se añaden implementaciones abajo.

    public Evento() {
    }

    public Evento(Long id, String titulo, String tipo, String modalidad, String sede, String estado, float precio, int capacidad) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.modalidad = modalidad;
        this.sede = sede;
        this.estado = estado;
        this.precio = precio;
        this.capacidad = capacidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public List<Sesion> getSesiones() {
        return sesiones;
    }

    public void setSesiones(List<Sesion> sesiones) {
        this.sesiones = sesiones;
    }
}