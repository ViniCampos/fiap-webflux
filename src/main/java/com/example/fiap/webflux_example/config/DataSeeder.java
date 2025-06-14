package com.example.fiap.webflux_example.config;

import com.example.fiap.webflux_example.model.Cliente;
import com.example.fiap.webflux_example.repository.ClienteRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class DataSeeder {

    private final ClienteRepository clienteRepository;

    @PostConstruct
    public void seed() {
        clienteRepository.deleteAll()
                .thenMany(
                        Flux.range(1, 20)
                                .map(i -> {
                                    Cliente c = new Cliente();
                                    c.setNome("Cliente " + i);
                                    return c;
                                })
                                .flatMap(clienteRepository::save)
                )
                .subscribe();
    }
}