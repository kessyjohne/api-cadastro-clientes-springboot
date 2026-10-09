package com.kessy.api.cadastro.cliente.controller;

import tools.jackson.databind.ObjectMapper;
import com.kessy.api.cadastro.cliente.model.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser
    public void deveCriarClienteComSucesso() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setNome("Maria Teste");
        cliente.setEmail("maria@teste.com");
        cliente.setTelefone("11999999999");

        mockMvc.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Maria Teste"))
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    @WithMockUser
    public void naoDeveCriarClienteSemNome() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setEmail("maria@teste.com");
        cliente.setTelefone("11999999999");

        mockMvc.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void naoDevePermitirAcessoSemAutenticacao() throws Exception {
        mockMvc.perform(get("/clientes"))
                .andExpect(status().isForbidden());
    }
}