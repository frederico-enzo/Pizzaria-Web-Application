package br.com.pizzariaapi.API.Controller;

import br.com.pizzariaapi.API.DTO.AtributoDTO;
import br.com.pizzariaapi.API.DTO.ClienteDTO;
import br.com.pizzariaapi.API.DTO.ProdutoDTO;
import br.com.pizzariaapi.API.Entity.Atributo;
import br.com.pizzariaapi.API.Entity.Produto;
import br.com.pizzariaapi.API.Service.AtributoService;
import br.com.pizzariaapi.API.Service.ClienteService;
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
    private ProdutoService service;
    @GetMapping(params = "id")
    public ResponseEntity<?>findById(@RequestParam("id") final Long id) {
        try {
            return ResponseEntity.ok(service.findById(id));
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error : " + e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody final ProdutoDTO DTO) {
        try {
            return ResponseEntity.ok(service.create(DTO));
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error : " + e.getMessage());
        }
    }
    @PutMapping(params = "id")
    public ResponseEntity<String> update(@RequestParam("id") final Long id, @RequestBody final ProdutoDTO DTO){
        try {
            return ResponseEntity.ok(service.update(id, DTO));
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error : " + e.getMessage());
        }
    }
    @DeleteMapping(params = "id")
    public ResponseEntity<?> delete(@RequestParam("id") final Long id){
        try {
            service.delete(id);
            return ResponseEntity.ok("Sucesso ao deletar Registro!");
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error : " + e.getMessage());
        }
    }


}
