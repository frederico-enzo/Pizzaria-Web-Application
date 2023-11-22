package br.com.pizzariaapi.api.controller;

import br.com.pizzariaapi.api.dto.EnderecoDTO;
import br.com.pizzariaapi.api.dto.UsuarioDTO;
import br.com.pizzariaapi.api.service.EnderecoService;
import br.com.pizzariaapi.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereços")
public class EnderecoController {
    @Autowired
    private EnderecoService service;
    @GetMapping("/find")
    public ResponseEntity<EnderecoDTO> findById(@RequestParam Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<EnderecoDTO>> findAll(){
        return ResponseEntity.ok(this.service.findAll());
    }
    @PostMapping("/create")
    public ResponseEntity<EnderecoDTO> post(@RequestBody EnderecoDTO enderecoDTO) {
        return ResponseEntity.ok(service.post(enderecoDTO));
    }
    @PutMapping("/update")
    public ResponseEntity<EnderecoDTO> put(@RequestParam Long id,@RequestBody  EnderecoDTO enderecoDTO) {
        return  ResponseEntity.ok(service.put(id, enderecoDTO));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}