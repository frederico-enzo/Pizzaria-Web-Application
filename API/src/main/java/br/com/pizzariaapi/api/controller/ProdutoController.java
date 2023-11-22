package br.com.pizzariaapi.api.controller;

import br.com.pizzariaapi.api.dto.ProdutoDTO;
import br.com.pizzariaapi.api.dto.UsuarioDTO;
import br.com.pizzariaapi.api.service.ProdutoService;
import br.com.pizzariaapi.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService service;
    @GetMapping("/find")
    public ResponseEntity<ProdutoDTO> findById(@RequestParam Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<ProdutoDTO>> findAll(){
        return ResponseEntity.ok(this.service.findAll());
    }
    @PostMapping("/create")
    public ResponseEntity<ProdutoDTO> post(@RequestBody ProdutoDTO produtoDTO) {
        return ResponseEntity.ok(service.post(produtoDTO));
    }
    @PutMapping("/update")
    public ResponseEntity<ProdutoDTO> put(@RequestParam Long id,@RequestBody  ProdutoDTO produtoDTO) {
        return  ResponseEntity.ok(service.put(id, produtoDTO));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
