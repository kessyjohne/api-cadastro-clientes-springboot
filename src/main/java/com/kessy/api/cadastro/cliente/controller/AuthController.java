package com.kessy.api.cadastro.cliente.controller;

import com.kessy.api.cadastro.cliente.model.Usuario;
import com.kessy.api.cadastro.cliente.repository.UsuarioRepository;
import com.kessy.api.cadastro.cliente.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/registrar")
    public Usuario registrar(@RequestBody Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario dadosLogin) {
        Usuario usuario = usuarioRepository.findByUsername(dadosLogin.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!passwordEncoder.matches(dadosLogin.getSenha(), usuario.getSenha())) {
            throw new RuntimeException("Senha inválida");
        }

        return jwtUtil.gerarToken(usuario.getUsername());
    }
}
