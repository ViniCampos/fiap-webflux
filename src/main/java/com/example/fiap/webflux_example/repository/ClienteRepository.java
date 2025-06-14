package com.example.fiap.webflux_example.repository;

import com.example.fiap.webflux_example.model.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ClienteRepository extends ReactiveMongoRepository<Cliente, String> {
}
