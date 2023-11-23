package br.com.pizzariaapi.api.controller;

import br.com.pizzariaapi.api.dto.PropriedadeDTO;

import br.com.pizzariaapi.api.service.PropriedadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/propriedades")
public class PropriedadeController {
    @Autowired
    private PropriedadeService service;
    @GetMapping("/find")
    public ResponseEntity<PropriedadeDTO> findById(@RequestParam Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<PropriedadeDTO>> findAll(){
        return ResponseEntity.ok(this.service.findAll());
    }
    @PostMapping("/create")
    public ResponseEntity<PropriedadeDTO> post(@RequestBody PropriedadeDTO propriedadeDTO) {
        return ResponseEntity.ok(service.post(propriedadeDTO));
    }
    @PutMapping("/update")
    public ResponseEntity<PropriedadeDTO> put(@RequestParam Long id,@RequestBody  PropriedadeDTO propriedadeDTO) {
        return  ResponseEntity.ok(service.put(propriedadeDTO, id));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
