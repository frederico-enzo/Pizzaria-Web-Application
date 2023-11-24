package br.com.pizzariaapi.api.controller;


import br.com.pizzariaapi.api.dto.ProdutoDTO;
import br.com.pizzariaapi.api.dto.SaborDTO;
import br.com.pizzariaapi.api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private  ProdutoService service;

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @PostMapping
    public ResponseEntity<ProdutoDTO> create(@RequestBody ProdutoDTO produtoDTO) {
        return ResponseEntity.ok(service.post(produtoDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> put(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        return ResponseEntity.ok(service.put(id, produtoDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
