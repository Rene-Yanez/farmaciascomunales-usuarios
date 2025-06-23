package com.farmaciascomunales.usuarios.model;

import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String correo;
    private String rol;
    
    @Column(nullable = false)
    private String contrasena;

    // Getters y setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return Correo; }

    public void setCorreo(String Correo) { this.Correo = Correo; }

    public String getRol() { return rol; }

    public void setRol(String rol) { this.rol = rol; }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    }