package br.com.pizzariaapi.API.Controller;

import br.com.pizzariaapi.API.DTO.EnderecoDTO;
import br.com.pizzariaapi.API.Service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService service;
    @GetMapping(params = "id")
    public ResponseEntity<?>findById(@RequestParam("id") final Long id) {
        try {
            return ResponseEntity.ok(service.findById(id));
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error : " + e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody final EnderecoDTO enderecoDTO) {
        try {
            return ResponseEntity.ok(service.create(enderecoDTO));
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error : " + e.getMessage());
        }
    }
    @PutMapping(params = "id")
    public ResponseEntity<String> update(@RequestParam("id") final Long id, @RequestBody final EnderecoDTO enderecoDTO){
        try {
            return ResponseEntity.ok(service.update(id, enderecoDTO));
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
