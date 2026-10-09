package com.kessy.api.cadastro.cliente.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    private final SecretKey chave = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
    private final long expiracao = 1000 * 60 * 60;

    public String gerarToken(String username) {
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expiracao))
                .signWith(chave)
                .compact();
    }

    public String extrairUsername(String token) {
        return Jwts.parser()
                .verifyWith(chave)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean tokenValido(String token, String username) {
        try {
            String usernameExtraido = extrairUsername(token);
            return usernameExtraido.equals(username);
        } catch (Exception e) {
            return false;
        }
    }
}
