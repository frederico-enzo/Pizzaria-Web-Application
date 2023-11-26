package br.com.pizzariaapi.api.controller;

import br.com.pizzariaapi.api.dto.AtributoDTO;
import br.com.pizzariaapi.api.dto.ClienteDTO;
import br.com.pizzariaapi.api.service.AtributoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/atributos")
public class AtributoController {
    @Autowired
    private  AtributoService service;
    @GetMapping("/{id}")
    public ResponseEntity<AtributoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping
    public ResponseEntity<List<AtributoDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @PostMapping
    public ResponseEntity<AtributoDTO> create(@RequestBody AtributoDTO atributoDTO) {
        return ResponseEntity.ok(service.post(atributoDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<AtributoDTO> put(@PathVariable Long id, @RequestBody AtributoDTO atributoDTO) {
        return ResponseEntity.ok(service.put(atributoDTO,id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
