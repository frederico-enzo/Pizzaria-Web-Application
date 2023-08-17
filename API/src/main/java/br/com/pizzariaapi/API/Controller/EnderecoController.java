package br.com.pizzariaapi.API.Controller;

import br.com.pizzariaapi.API.DTO.ClienteDTO;
import br.com.pizzariaapi.API.DTO.EnderecoDTO;
import br.com.pizzariaapi.API.Entity.Cliente;
import br.com.pizzariaapi.API.Entity.Endereco;
import br.com.pizzariaapi.API.Service.EnderecoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/Endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;
    @GetMapping(params = "id")
    public ResponseEntity<?>findById(@RequestParam("id") final Long id) {
        Endereco endereco = enderecoService.findById(id);
        return endereco == null
                ? ResponseEntity.badRequest().body("Endereço não encontrado")
                : ResponseEntity.ok(endereco);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody final EnderecoDTO enderecoDTO){
        try{
            this.enderecoService.create(enderecoDTO);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        }catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping(params = "id")
    public ResponseEntity<?> update(@RequestParam("id") final Long id, @RequestBody final EnderecoDTO enderecoDTO){
        try{
            this.enderecoService.update(id, enderecoDTO);
            return ResponseEntity.ok("Registro editado com sucesso");
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping(params = "id")
    public ResponseEntity<?> delete(@RequestParam("id") final Long id) {
        try {
            enderecoService.delete(id);
            return ResponseEntity.ok("Registro deletado com sucesso");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body("Endereço não encontrado");
        }
    }

}
