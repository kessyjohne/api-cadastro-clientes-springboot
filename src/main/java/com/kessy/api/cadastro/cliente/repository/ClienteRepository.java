package com.kessy.api.cadastro.cliente.repository;

import com.kessy.api.cadastro.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository < Cliente, Long > {
}
