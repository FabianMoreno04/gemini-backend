package com.gemini.gemini_backend.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Direccion")
public class Direccion implements Serializable {

    @Id
    @Column(length = 36, name = "ID_direccion")
    private String idDireccion;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "descripcion_adicional")
    private String descripcionAdicional;

    @Column(name = "depende_de")
    private String dependeDe;

    // 🔹 Constructores
    public Direccion() {
    }

    public Direccion(String idDireccion, String nombre, String descripcionAdicional, String dependeDe) {
        this.idDireccion = idDireccion;
        this.nombre = nombre;
        this.descripcionAdicional = descripcionAdicional;
        this.dependeDe = dependeDe;
    }

    // 🔹 Getters y Setters
    public String getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(String idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcionAdicional() {
        return descripcionAdicional;
    }

    public void setDescripcionAdicional(String descripcionAdicional) {
        this.descripcionAdicional = descripcionAdicional;
    }

    public String getDependeDe() {
        return dependeDe;
    }

    public void setDependeDe(String dependeDe) {
        this.dependeDe = dependeDe;
    }

    // 🔹 toString
    @Override
    public String toString() {
        return "Direccion{" +
                "idDireccion='" + idDireccion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcionAdicional='" + descripcionAdicional + '\'' +
                ", dependeDe='" + dependeDe + '\'' +
                '}';
    }
}
