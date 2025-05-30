package cl.farmaciascomunales.usuarios.service;

import cl.farmaciascomunales.usuarios.model.Usuario;
import cl.farmaciascomunales.usuarios.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<Usuario> getAll() {
        return repo.findAll();
    }

    public Usuario save(Usuario user) {
        return repo.save(user);
    }

    public Usuario getById(Long id) {
        return repo.findById(id).orElse(null);
    }
}