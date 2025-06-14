package com.example.fiap.webflux_example.service;

import com.example.fiap.webflux_example.model.Cliente;
import com.example.fiap.webflux_example.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Flux<Cliente> buscarPrimeiros10() {
        return clienteRepository.findAll().take(10);
    }
}
