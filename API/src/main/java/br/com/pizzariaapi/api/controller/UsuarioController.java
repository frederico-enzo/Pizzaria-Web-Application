package br.com.pizzariaapi.api.controller;

import br.com.pizzariaapi.api.dto.UsuarioDTO;
import br.com.pizzariaapi.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
@Autowired
private UsuarioService service;
    @GetMapping("/find")
    public ResponseEntity<UsuarioDTO> findById(@RequestParam  Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<UsuarioDTO>> findAll(){
        return ResponseEntity.ok(this.service.findAll());
    }
    @PostMapping("/create")
    public ResponseEntity<UsuarioDTO> post(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(service.post(usuarioDTO));
    }
    @PutMapping("/update")
    public ResponseEntity<UsuarioDTO> put(@RequestParam Long id,@RequestBody  UsuarioDTO usuarioDTO) {
        return  ResponseEntity.ok(service.put(usuarioDTO, id));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
