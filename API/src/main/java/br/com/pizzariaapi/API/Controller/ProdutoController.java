package br.com.pizzariaapi.API.Controller;

import br.com.pizzariaapi.API.DTO.AtributoDTO;
import br.com.pizzariaapi.API.DTO.ProdutoDTO;
import br.com.pizzariaapi.API.Entity.Atributo;
import br.com.pizzariaapi.API.Entity.Produto;
import br.com.pizzariaapi.API.Service.AtributoService;
import br.com.pizzariaapi.API.Service.ProdutoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;
    @GetMapping(params = "id")
    public ResponseEntity<?> findById(@RequestParam("id") final Long id){
        Produto produto = produtoService.findById(id);
        return produto == null
                ? ResponseEntity.badRequest().body("Registro  não encontrado")
                : ResponseEntity.ok(produto);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody final ProdutoDTO produtoDTO){
        try{
            this.produtoService.create(produtoDTO);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        }catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping(params = "id")
    public ResponseEntity<?> update(@RequestParam("id") final Long id, @RequestBody final ProdutoDTO produtoDTO){
        try{
            this.produtoService.update(id, produtoDTO);
            return ResponseEntity.ok("Registro editado com sucesso");
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping(params = "id")
    public ResponseEntity<?> delete(@RequestParam("id") final Long id) {
        try {
            produtoService.delete(id);
            return ResponseEntity.ok("Registro deletado com sucesso");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getCause());
        }
    }



}
