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
    public ResponseEntity<AtributoDTO> getAtributoById(@PathVariable Long id) {
        AtributoDTO atributoDTO = service.findById(id);
        if (atributoDTO != null) {
            return ResponseEntity.ok(atributoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public ResponseEntity<List<AtributoDTO>> getAll() {
        List<AtributoDTO> atributoDTOS = service.findAll();
        return ResponseEntity.ok(atributoDTOS);
    }
    @PostMapping
    public ResponseEntity<AtributoDTO> createAtributo(@RequestBody AtributoDTO atributoDTO) {
        AtributoDTO createdAtributo = service.post(atributoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAtributo);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AtributoDTO> updateAtributo(@PathVariable Long id, @RequestBody AtributoDTO atributoDTO) {
        atributoDTO.setId(id);
        AtributoDTO updatedAtributo = service.put(atributoDTO);
        return ResponseEntity.ok(updatedAtributo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtributo(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
