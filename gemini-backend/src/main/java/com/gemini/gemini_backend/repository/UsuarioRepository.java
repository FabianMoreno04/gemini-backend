package com.gemini.gemini_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gemini.gemini_backend.entity.Usuario;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
