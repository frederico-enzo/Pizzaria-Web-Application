package br.com.pizzariaapi.API.Controller;
import br.com.pizzariaapi.API.DTO.ClienteDTO;
import br.com.pizzariaapi.API.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cliente")
public class ClienteCotroller {
    @Autowired
    private ClienteService service;
    @GetMapping(params = "id")
    public ResponseEntity<?>findById(@RequestParam("id") final Long id) {
           try {
               return ResponseEntity.ok(service.findById(id));
           }catch(Exception e){
               return ResponseEntity.badRequest().body("Error : " + e.getMessage());
           }
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody final ClienteDTO cliente) {
        try {
            return ResponseEntity.ok(service.create(cliente));
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error : " + e.getMessage());
        }
    }
    @PutMapping(params = "id")
    public ResponseEntity<String> update(@RequestParam("id") final Long id, @RequestBody final ClienteDTO cliente){
        try {
            return ResponseEntity.ok(service.update(id, cliente));
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
