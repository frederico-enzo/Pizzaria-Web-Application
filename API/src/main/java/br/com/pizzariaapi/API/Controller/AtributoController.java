package br.com.pizzariaapi.API.Controller;

import br.com.pizzariaapi.API.DTO.AtributoDTO;
import br.com.pizzariaapi.API.Entity.Atributo;
import br.com.pizzariaapi.API.Service.AtributoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/atributo")
public class AtributoController {
    @Autowired
    private AtributoService atributoService;
    @GetMapping(params = "id")
    public ResponseEntity<?> findById(@RequestParam("id") final Long id){
        Atributo atributo = atributoService.findById(id);
        return atributo == null
                ? ResponseEntity.badRequest().body("Registro  não encontrado")
                : ResponseEntity.ok(atributo);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody final AtributoDTO atributoDTO){
        try{
            this.atributoService.create(atributoDTO);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        }catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping(params = "id")
    public ResponseEntity<?> update(@RequestParam("id") final Long id, @RequestBody final AtributoDTO atributoDTO){
        try{
            this.atributoService.update(id, atributoDTO);
            return ResponseEntity.ok("Registro editado com sucesso");
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping(params = "id")
    public ResponseEntity<?> delete(@RequestParam("id") final Long id) {
        try {
            atributoService.delete(id);
            return ResponseEntity.ok("Registro deletado com sucesso");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getCause());
        }
    }


}
