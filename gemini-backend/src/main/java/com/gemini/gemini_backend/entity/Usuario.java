package com.gemini.gemini_backend.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username; // puede ser correo

    @Column(nullable = false)
    private String password; // bcrypt

    @Column(length = 20, name = "persona_dni")
    private String personaDni; // FK lógico hacia Persona (no forzado por JPA)

    @Column(nullable = false)
    private String role; // e.g., ROLE_ADMIN, ROLE_USER

    // 🔹 Constructores
    public Usuario() {
    }

    public Usuario(Long id, String username, String password, String personaDni, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.personaDni = personaDni;
        this.role = role;
    }

    // 🔹 Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonaDni() {
        return personaDni;
    }

    public void setPersonaDni(String personaDni) {
        this.personaDni = personaDni;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // 🔹 toString
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", personaDni='" + personaDni + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
