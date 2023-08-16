package br.com.pizzariaapi.API.Controller;

import br.com.pizzariaapi.API.DTO.ClienteDTO;
import br.com.pizzariaapi.API.DTO.EnderecoDTO;
import br.com.pizzariaapi.API.Entity.ClienteEntity;
import br.com.pizzariaapi.API.Entity.EnderecoEntity;
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
    public ResponseEntity<EnderecoEntity> findById(@RequestParam("id") final Long id) {
        try {
            final EnderecoEntity endereco = enderecoService.findById(id);
            return ResponseEntity.ok(endereco);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
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



}
