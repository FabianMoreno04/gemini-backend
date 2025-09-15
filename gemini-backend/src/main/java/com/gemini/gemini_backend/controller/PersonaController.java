package com.gemini.gemini_backend.controller;

import com.gemini.gemini_backend.entity.Persona;
import com.gemini.gemini_backend.service.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {
    private final PersonaService service;

    public PersonaController(PersonaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Persona>> listar() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Persona> obtener(@PathVariable String dni) {
        return service.findByDni(dni)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Persona> crear(@RequestBody Persona p) {
        if (p.getDni() == null || p.getDni().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        Persona saved = service.save(p);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{dni}")
    public ResponseEntity<Persona> actualizar(@PathVariable String dni, @RequestBody Persona p) {
        return service.findByDni(dni).map(existing -> {
            // actualizar campos permisibles
            existing.setNombre(p.getNombre());
            existing.setCorreo(p.getCorreo());
            existing.setTelefono(p.getTelefono());
            existing.setRol(p.getRol());
            Persona updated = service.save(existing);
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<Void> eliminar(@PathVariable String dni) {
        service.delete(dni);
        return ResponseEntity.noContent().build();
    }
}
