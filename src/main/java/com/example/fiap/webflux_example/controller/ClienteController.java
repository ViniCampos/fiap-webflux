package com.example.fiap.webflux_example.controller;

import com.example.fiap.webflux_example.dto.ClienteDTO;
import com.example.fiap.webflux_example.model.Cliente;
import com.example.fiap.webflux_example.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping("/clientes")
    public Flux<ClienteDTO> getClientes() {
        return clienteService.buscarPrimeiros10()
                .map(ClienteDTO::fromEntity); // Igual .map(cliente -> ClienteDTO.fromEntity(cliente))
    }

    //Usando stream
    @GetMapping(value = "/clientes-stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ClienteDTO> getClientesStream() {
        return clienteService.buscarPrimeiros10()
                .map(ClienteDTO::fromEntity);
    }
}
