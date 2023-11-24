package br.com.pizzariaapi.api.controller;

import br.com.pizzariaapi.api.dto.AtributoDTO;
import br.com.pizzariaapi.api.dto.PedidoDTO;
import br.com.pizzariaapi.api.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private  PedidoService service;

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> getPedidoById(@PathVariable Long id) {
        PedidoDTO pedidoDTO = service.findById(id);
        return ResponseEntity.ok(pedidoDTO);
    }
    @GetMapping
    public ResponseEntity<List<PedidoDTO>> getAll() {
        List<PedidoDTO> pedidoDTOS = service.findAll();
        return ResponseEntity.ok(pedidoDTOS);
    }
    @PostMapping
    public ResponseEntity<String> createPedido(@RequestBody PedidoDTO pedidoDTO) {
        String responseMessage = service.create(pedidoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO) {
        String responseMessage = service.update(id, pedidoDTO);
        return ResponseEntity.ok(responseMessage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
