package cl.farmaciascomunales.usuarios.controller;

import cl.farmaciascomunales.usuarios.model.Usuario;
import cl.farmaciascomunales.usuarios.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuario> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario user) {
        return service.save(user);
    }

    @GetMapping("/{id}")
    public Usuario getById(@PathVariable Long id) {
        return service.getById(id);
    }
}