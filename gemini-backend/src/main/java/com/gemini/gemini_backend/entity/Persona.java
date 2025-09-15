package com.gemini.gemini_backend.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Persona")
public class Persona implements Serializable {

    @Id
    @Column(length = 20)
    private String dni;

    @Column(name = "tipo_dni")
    private String tipoDni;

    @Column(nullable = false)
    private String nombre;

    private String telefono;

    @Column(unique = true)
    private String correo;

    private String rol; // 'Cliente', 'Empleado', etc.

    @Column(name = "ID_direccion")
    private String idDireccion;

    @Column(name = "ID_cargo_especialidad")
    private String idCargoEspecialidad;

    // 🔹 Constructores
    public Persona() {
    }

    public Persona(String dni, String tipoDni, String nombre, String telefono,
            String correo, String rol, String idDireccion, String idCargoEspecialidad) {
        this.dni = dni;
        this.tipoDni = tipoDni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.rol = rol;
        this.idDireccion = idDireccion;
        this.idCargoEspecialidad = idCargoEspecialidad;
    }

    // 🔹 Getters y Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTipoDni() {
        return tipoDni;
    }

    public void setTipoDni(String tipoDni) {
        this.tipoDni = tipoDni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(String idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getIdCargoEspecialidad() {
        return idCargoEspecialidad;
    }

    public void setIdCargoEspecialidad(String idCargoEspecialidad) {
        this.idCargoEspecialidad = idCargoEspecialidad;
    }

    // 🔹 toString
    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", tipoDni='" + tipoDni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", rol='" + rol + '\'' +
                ", idDireccion='" + idDireccion + '\'' +
                ", idCargoEspecialidad='" + idCargoEspecialidad + '\'' +
                '}';
    }
}
