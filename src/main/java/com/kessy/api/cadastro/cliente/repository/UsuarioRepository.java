package com.kessy.api.cadastro.cliente.repository;

import com.kessy.api.cadastro.cliente.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{
    Optional<Usuario> findByUsername(String username);
}
