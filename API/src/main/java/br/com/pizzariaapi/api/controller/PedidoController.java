package br.com.pizzariaapi.api.controller;

import br.com.pizzariaapi.api.dto.AtributoDTO;
import br.com.pizzariaapi.api.dto.PedidoDTO;
import br.com.pizzariaapi.api.dto.SaborDTO;
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
    public ResponseEntity<PedidoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping
    public ResponseEntity<List<PedidoDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @PostMapping
    public ResponseEntity<PedidoDTO> create(@RequestBody PedidoDTO pedidoDTO) {
        return ResponseEntity.ok(service.post(pedidoDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> put(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO) {
        return ResponseEntity.ok(service.put(id, pedidoDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
