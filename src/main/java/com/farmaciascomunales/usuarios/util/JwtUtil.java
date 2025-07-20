package com.farmaciascomunales.usuarios.util;

import com.farmaciascomunales.usuarios.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    // Clave secreta (puedes moverla a application.properties en producción)
    private final String SECRET_KEY = "secreto-farmacia-comunal";

    // Tiempo de expiración (en milisegundos): 1 día
    private final long EXPIRATION_TIME = 1000 * 60 * 60 * 24;

    public String generateToken(Usuario usuario) {
        return Jwts.builder()
                .setSubject(usuario.getCorreo())  // identificador principal
                .claim("rol", usuario.getRol())   // puedes agregar más datos si deseas
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}