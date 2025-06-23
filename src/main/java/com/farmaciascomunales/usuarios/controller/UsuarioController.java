package com.farmaciascomunales.usuarios.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.farmaciascomunales.usuarios.model.Usuario;
import com.farmaciascomunales.usuarios.service.UsuarioService;
import com.farmaciascomunales.usuarios.dto.LoginRequest;

import java.util.List;

@CrossOrigin(origins = "https://farmaciascomunales-frontend.onrender.com")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Usuario usuario = service.buscarPorCorreo(loginRequest.getCorreo());

        if (usuario == null || !usuario.getContrasena().equals(loginRequest.getContrasena())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }

        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public List<Usuario> listar() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Usuario obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        return service.crear(usuario);
    }
}