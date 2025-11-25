package com.tuempresa.talleres.dto;

public class RegistroParticipanteRequest {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String institucion;
    private String tipoParticipante;

    // Constructor vacío
    public RegistroParticipanteRequest() {
    }

    // Constructor con parámetros
    public RegistroParticipanteRequest(String nombre, String apellido, String email, String telefono, String institucion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.institucion = institucion;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getTipoParticipante() {
        return tipoParticipante;
    }

    public void setTipoParticipante(String tipoParticipante) {
        this.tipoParticipante = tipoParticipante;
    }

    @Override
    public String toString() {
        return "RegistroParticipanteRequest{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", institucion='" + institucion + '\'' +
                ", tipoParticipante='" + tipoParticipante + '\'' +
                '}';
    }
}