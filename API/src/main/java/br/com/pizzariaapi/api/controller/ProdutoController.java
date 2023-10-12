package br.com.pizzariaapi.api.controller;


import br.com.pizzariaapi.api.dto.ProdutoDTO;
import br.com.pizzariaapi.api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private  ProdutoService service;

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getProdutoById(@PathVariable Long id) {
        ProdutoDTO produtoDTO = service.findById(id);
        return ResponseEntity.ok(produtoDTO);
    }

    @PostMapping
    public ResponseEntity<String> createProduto(@RequestBody ProdutoDTO produtoDTO) {
        String responseMessage = service.create(produtoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        String responseMessage = service.update(id, produtoDTO);
        return ResponseEntity.ok(responseMessage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
