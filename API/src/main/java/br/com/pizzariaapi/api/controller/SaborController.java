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
    public ResponseEntity<SaborDTO> getSaborById(@PathVariable Long id) {
        SaborDTO saborDTO = service.findById(id);
        return ResponseEntity.ok(saborDTO);
    }

    @GetMapping
    public ResponseEntity<List<SaborDTO>> getAllSabores() {
        List<SaborDTO> saborDTOs = service.findAll();
        return ResponseEntity.ok(saborDTOs);
    }

    @PostMapping
    public ResponseEntity<String> createSabor(@RequestBody SaborDTO saborDTO) {
        try {
            String responseMessage = service.create(saborDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro durante a criação do sabor");
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateSabor(@PathVariable Long id, @RequestBody SaborDTO saborDTO) {
        try{
        String responseMessage = service.update(id, saborDTO);
        return ResponseEntity.ok(responseMessage);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro durante a criação do sabor");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSabor(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
