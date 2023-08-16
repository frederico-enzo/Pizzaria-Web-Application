package br.com.pizzariaapi.API.Controller;
import br.com.pizzariaapi.API.DTO.ClienteDTO;
import br.com.pizzariaapi.API.Entity.ClienteEntity;
import br.com.pizzariaapi.API.Service.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/Cliente")
public class ClienteCotroller {
    @Autowired
    private ClienteService clienteService;
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            ClienteEntity cliente = clienteService.findById(id);
            return ResponseEntity.ok(cliente.getEnderecos());
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao buscar o cliente.");
        }
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
    public ResponseEntity<?> update(@RequestParam("id") final Long id,@RequestBody final ClienteDTO cliente){
        try{
            this.clienteService.update(cliente);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        }catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @DeleteMapping(params = "id")
    public ResponseEntity<?> delete(@RequestParam("id") final Long id){
        try{
            clienteService.delete(id);
            return ResponseEntity.ok("");
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
