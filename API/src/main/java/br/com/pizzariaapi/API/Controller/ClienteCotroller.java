package br.com.pizzariaapi.API.Controller;
import br.com.pizzariaapi.API.DTO.ClienteDTO;
import br.com.pizzariaapi.API.Entity.Cliente;
import br.com.pizzariaapi.API.Service.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cliente")
public class ClienteCotroller {
    @Autowired
    private ClienteService clienteService;

    @GetMapping(params = "id")
    public ResponseEntity<?>findById(@RequestParam("id") final Long id) {
            ClienteDTO cliente = clienteService.findById(id);
            return cliente == null
                    ? ResponseEntity.badRequest().body("Cliente não encontrado")
                    : ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody final ClienteDTO cliente) {
        try {
            this.clienteService.create(cliente);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar o registro: " + e.getMessage());
        }
    }

    @PutMapping(params = "id")
    public ResponseEntity<?> update(@RequestParam("id") final Long id, @RequestBody final ClienteDTO cliente){
        try{
            this.clienteService.update(id, cliente);
            return ResponseEntity.ok("Registro editado com sucesso");
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<?> delete(@RequestParam("id") final Long id){
        try{
            clienteService.delete(id);
            return ResponseEntity.ok("Registro deletado com sucesso");
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
