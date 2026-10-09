package com.kessy.api.cadastro.cliente.controller;

import com.kessy.api.cadastro.cliente.model.Cliente;
import com.kessy.api.cadastro.cliente.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public Cliente criar(@Valid @RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @GetMapping
    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@Valid @PathVariable Long id, @RequestBody Cliente clienteAtualizado){
        clienteAtualizado.setId(id);
        return clienteRepository.save(clienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletar (@PathVariable Long id) {
        clienteRepository.deleteById(id);
    }
}
