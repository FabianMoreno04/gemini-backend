package com.gemini.gemini_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gemini.gemini_backend.entity.Persona;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, String> {
    Optional<Persona> findByCorreo(String correo);
}