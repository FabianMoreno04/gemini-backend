package com.gemini.gemini_backend.service;

import com.gemini.gemini_backend.entity.*;
import com.gemini.gemini_backend.repository.PersonaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    private final PersonaRepository repo;

    public PersonaService(PersonaRepository repo) {
        this.repo = repo;
    }

    public List<Persona> findAll() {
        return repo.findAll();
    }

    public Optional<Persona> findByDni(String dni) {
        return repo.findById(dni);
    }

    public Persona save(Persona p) {
        return repo.save(p);
    }

    public void delete(String dni) {
        repo.deleteById(dni);
    }
}
