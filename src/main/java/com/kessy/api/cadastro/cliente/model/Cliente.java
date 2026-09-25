package com.kessy.api.cadastro.cliente.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "clientes")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório!")
    private String nome;

    @NotBlank(message = "Email é obrigatório!")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "Telefone é obrigatório!")
    private String telefone;
}
