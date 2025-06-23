package com.farmaciascomunales.usuarios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmaciascomunales.usuarios.model.Usuario;
import com.farmaciascomunales.usuarios.repository.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario buscarPorCorreo(String email) {
        return usuarioRepository.findByCorreo(email);
    }

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