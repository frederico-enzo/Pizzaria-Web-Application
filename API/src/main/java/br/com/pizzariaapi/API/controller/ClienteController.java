package br.com.pizzariaapi.api.controller;

import br.com.pizzariaapi.api.dto.ClienteDTO;
import br.com.pizzariaapi.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private  ClienteService service;

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable Long id) {
        ClienteDTO clienteDTO = service.findById(id);
        return ResponseEntity.ok(clienteDTO);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAllClientes() {
        List<ClienteDTO> clienteDTOs = service.findAll();
        return ResponseEntity.ok(clienteDTOs);
    }

    @PostMapping
    public ResponseEntity<String> createCliente(@RequestBody ClienteDTO clienteDTO) {
        String responseMessage = service.create(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        String responseMessage = service.update(id, clienteDTO);
        return ResponseEntity.ok(responseMessage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
