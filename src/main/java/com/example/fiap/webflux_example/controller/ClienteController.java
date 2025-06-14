package com.example.fiap.webflux_example.controller;

import com.example.fiap.webflux_example.model.Cliente;
import com.example.fiap.webflux_example.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public Flux<Cliente> getClientes() {
        return clienteRepository.findAll().take(10);
    }
}
