package com.farmaciascomunales.usuarios.service;

import com.farmaciascomunales.usuarios.model.Usuario;
import com.farmaciascomunales.usuarios.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> obtenerTodos() {
        return repository.findAll();
    }

    public Usuario obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Usuario crear(Usuario usuario) {
        return repository.save(usuario);
    }
}