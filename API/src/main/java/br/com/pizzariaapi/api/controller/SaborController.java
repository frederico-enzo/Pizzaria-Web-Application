package br.com.pizzariaapi.api.controller;

import br.com.pizzariaapi.api.dto.SaborDTO;
import br.com.pizzariaapi.api.service.SaborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sabores")
public class SaborController {
    @Autowired
    private SaborService service;
    @GetMapping("/find")
    public ResponseEntity<SaborDTO> findById(@RequestParam Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<SaborDTO>> findAll(){
        return ResponseEntity.ok(this.service.findAll());
    }
    @PostMapping("/create")
    public ResponseEntity<SaborDTO> post(@RequestBody SaborDTO saborDTO) {
        return ResponseEntity.ok(service.post(saborDTO));
    }
    @PutMapping("/update")
    public ResponseEntity<SaborDTO> put(@RequestParam Long id,@RequestBody  SaborDTO saborDTO) {
        return  ResponseEntity.ok(service.put(saborDTO, id));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
