package br.com.pizzariaapi.api.controller;

import br.com.pizzariaapi.api.dto.TamanhoDTO;
import br.com.pizzariaapi.api.service.TamanhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tamanhos")
public class TamanhoController {
    @Autowired
    private TamanhoService service;
    @GetMapping("/find")
    public ResponseEntity<TamanhoDTO> findById(@RequestParam Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<TamanhoDTO>> findAll(){
        return ResponseEntity.ok(this.service.findAll());
    }
    @PostMapping("/create")
    public ResponseEntity<TamanhoDTO> post(@RequestBody TamanhoDTO tamanhoDTO) {
        return ResponseEntity.ok(service.post(tamanhoDTO));
    }
    @PutMapping("/update")
    public ResponseEntity<TamanhoDTO> put(@RequestParam Long id,@RequestBody  TamanhoDTO tamanhoDTO) {
        return  ResponseEntity.ok(service.put(tamanhoDTO, id));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
