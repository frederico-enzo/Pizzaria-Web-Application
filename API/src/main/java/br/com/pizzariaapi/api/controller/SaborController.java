package br.com.pizzariaapi.api.controller;

import br.com.pizzariaapi.api.dto.SaborDTO;
import br.com.pizzariaapi.api.service.SaborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/sabores")
public class SaborController {
    @Autowired
    private  SaborService service;

    @GetMapping("/{id}")
    public ResponseEntity<SaborDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping
    public ResponseEntity<List<SaborDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @PostMapping
    public ResponseEntity<SaborDTO> create(@RequestBody SaborDTO saborDTO) {
        return ResponseEntity.ok(service.post(saborDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<SaborDTO> put(@PathVariable Long id, @RequestBody SaborDTO saborDTO) {
        return ResponseEntity.ok(service.put(id, saborDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
