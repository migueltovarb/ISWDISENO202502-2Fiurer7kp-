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
    private String codigoTransaccion;
    private Date fecha;

    @ManyToOne
    private Inscripcion inscripcion;

    // Constructores
    public Pago() {}

    public Pago(float monto, String estado, String referencia, Date fecha) {
        this.monto = monto;
        this.estado = estado;
        this.referencia = referencia;
        this.fecha = fecha;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public float getMonto() { return monto; }
    public void setMonto(float monto) { this.monto = monto; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getReferencia() { return referencia; }
    public void setReferencia(String referencia) { this.referencia = referencia; }

    public String getCodigoTransaccion() { return codigoTransaccion; }
    public void setCodigoTransaccion(String codigoTransaccion) { this.codigoTransaccion = codigoTransaccion; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public Inscripcion getInscripcion() { return inscripcion; }
    public void setInscripcion(Inscripcion inscripcion) { this.inscripcion = inscripcion; }
}