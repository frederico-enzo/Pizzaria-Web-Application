package br.com.pizzariaapi.api.controller;


import br.com.pizzariaapi.api.dto.EnderecoDTO;
import br.com.pizzariaapi.api.dto.ItemDTO;
import br.com.pizzariaapi.api.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoService service;

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @PostMapping
    public ResponseEntity<EnderecoDTO> create(@RequestBody EnderecoDTO enderecoDTO) {
        return ResponseEntity.ok(service.post(enderecoDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTO> put(@PathVariable Long id, @RequestBody EnderecoDTO enderecoDTO) {
        return ResponseEntity.ok(service.put(id, enderecoDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
