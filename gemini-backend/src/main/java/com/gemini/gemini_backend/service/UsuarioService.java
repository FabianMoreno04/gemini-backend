package com.gemini.gemini_backend.service;

import com.gemini.gemini_backend.entity.Usuario;
import com.gemini.gemini_backend.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository repo;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario create(String username, String rawPassword, String personaDni, String role) {
        Usuario u = new Usuario();
        u.setUsername(username);
        u.setPassword(passwordEncoder.encode(rawPassword));
        u.setPersonaDni(personaDni);
        u.setRole(role);
        return repo.save(u);
    }

    public Optional<Usuario> findByUsername(String username) {
        return repo.findByUsername(username);
    }
}
