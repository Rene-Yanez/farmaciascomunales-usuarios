package com.farmaciascomunales.usuarios.dto;

public class LoginRequest {
    private String email;
    private String contrasena;

    // Getters y Setters
    public String getCorreo() {
        return email;
    }

    public void setCorreo(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}