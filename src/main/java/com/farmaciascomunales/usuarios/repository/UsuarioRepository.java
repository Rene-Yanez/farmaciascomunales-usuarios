package com.farmaciascomunales.usuarios.repository;

import com.farmaciascomunales.usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCorreo(String email);
}
