package br.com.pizzariaapi.api.controller;

import br.com.pizzariaapi.api.dto.ItemDTO;
import br.com.pizzariaapi.api.dto.PedidoDTO;
import br.com.pizzariaapi.api.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/itens")
public class ItemController {
    @Autowired
    private  ItemService service;

    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping
    public ResponseEntity<List<ItemDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @PostMapping
    public ResponseEntity<ItemDTO> create(@RequestBody ItemDTO itemDTO) {
        return ResponseEntity.ok(service.post(itemDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ItemDTO> put(@PathVariable Long id, @RequestBody ItemDTO itemDTO) {
        return ResponseEntity.ok(service.put(id, itemDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
