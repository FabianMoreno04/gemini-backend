package com.gemini.gemini_backend.controller;

import com.gemini.gemini_backend.dto.AuthRequest;
import com.gemini.gemini_backend.dto.AuthResponse;
import com.gemini.gemini_backend.entity.Usuario;
import com.gemini.gemini_backend.service.UsuarioService;
import com.gemini.gemini_backend.config.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final UsuarioService usuarioService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authManager, UsuarioService usuarioService, JwtUtil jwtUtil) {
        this.authManager = authManager;
        this.usuarioService = usuarioService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        Usuario user = usuarioService.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtUtil.generateToken(user.getUsername(), user.getRole());
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequest request) {
        // ejemplo: para registrar usuario vinculado a una persona ya existente
        Usuario u = usuarioService.create(request.getUsername(), request.getPassword(), request.getPersonaDni(),
                "ROLE_USER");
        return ResponseEntity.ok(u);
    }
}