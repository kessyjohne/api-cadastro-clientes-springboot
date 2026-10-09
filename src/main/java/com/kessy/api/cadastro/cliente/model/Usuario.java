package com.kessy.api.cadastro.cliente.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Usuarios")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String senha;
}
