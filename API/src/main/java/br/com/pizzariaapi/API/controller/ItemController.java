package br.com.pizzariaapi.api.controller;

import br.com.pizzariaapi.api.dto.ItemDTO;
import br.com.pizzariaapi.api.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/itens")
public class ItemController {
    @Autowired
    private  ItemService service;

    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable Long id) {
        ItemDTO itemDTO = service.findById(id);
        return ResponseEntity.ok(itemDTO);
    }

    @PostMapping
    public ResponseEntity<String> createItem(@RequestBody ItemDTO itemDTO) {
        String responseMessage = service.create(itemDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateItem(@PathVariable Long id, @RequestBody ItemDTO itemDTO) {
        String responseMessage = service.update(id, itemDTO);
        return ResponseEntity.ok(responseMessage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
