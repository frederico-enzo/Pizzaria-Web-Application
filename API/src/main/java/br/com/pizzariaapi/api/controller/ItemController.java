package br.com.pizzariaapi.api.controller;

import br.com.pizzariaapi.api.dto.ItemDTO;
import br.com.pizzariaapi.api.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemController {
    @Autowired
    private ItemService service;
    @GetMapping("/find")
    public ResponseEntity<ItemDTO> findById(@RequestParam Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<ItemDTO>> findAll(){
        return ResponseEntity.ok(this.service.findAll());
    }
    @PostMapping("/create")
    public ResponseEntity<ItemDTO> post(@RequestBody ItemDTO itemDTO) {
        return ResponseEntity.ok(service.post(itemDTO));
    }
    @PutMapping("/update")
    public ResponseEntity<ItemDTO> put(@RequestParam Long id,@RequestBody  ItemDTO itemDTO) {
        return  ResponseEntity.ok(service.put(itemDTO, id));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

