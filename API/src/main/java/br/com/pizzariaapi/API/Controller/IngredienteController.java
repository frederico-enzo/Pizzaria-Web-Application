package br.com.pizzariaapi.API.Controller;

import br.com.pizzariaapi.API.DTO.IngredientesDTO;
import br.com.pizzariaapi.API.Entity.Ingrediente;
import br.com.pizzariaapi.API.Service.IngredienteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ingrediente")
public class IngredienteController {
    @Autowired
    private IngredienteService ingredienteService;
    @GetMapping(params = "id")
    public ResponseEntity<?> findById(@RequestParam("id") final Long id){
        Ingrediente ingrediente = ingredienteService.findById(id);
        return ingrediente == null
                ? ResponseEntity.badRequest().body("Registro  não encontrado")
                : ResponseEntity.ok(ingrediente);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody final IngredientesDTO ingredientesDTO){
        try{
            this.ingredienteService.create(ingredientesDTO);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        }catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping(params = "id")
    public ResponseEntity<?> update(@RequestParam("id") final Long id, @RequestBody final IngredientesDTO ingredientesDTO){
        try{
            this.ingredienteService.update(id, ingredientesDTO);
            return ResponseEntity.ok("Registro editado com sucesso");
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping(params = "id")
    public ResponseEntity<?> delete(@RequestParam("id") final Long id) {
        try {
            ingredienteService.delete(id);
            return ResponseEntity.ok("Registro deletado com sucesso");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getCause());
        }
    }

}
