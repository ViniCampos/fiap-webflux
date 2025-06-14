package com.example.fiap.webflux_example.dto;


import com.example.fiap.webflux_example.model.Cliente;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ClienteDTO {
    private String nome;

    public static ClienteDTO fromEntity(Cliente cliente) {
        return new ClienteDTO(cliente.getNome());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}