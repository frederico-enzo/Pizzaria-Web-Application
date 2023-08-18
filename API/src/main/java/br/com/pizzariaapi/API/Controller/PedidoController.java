package br.com.pizzariaapi.API.Controller;

import br.com.pizzariaapi.API.DTO.ItemDTO;
import br.com.pizzariaapi.API.DTO.PedidoDTO;
import br.com.pizzariaapi.API.Entity.Item;
import br.com.pizzariaapi.API.Entity.Pedido;
import br.com.pizzariaapi.API.Service.ItemService;
import br.com.pizzariaapi.API.Service.PedidoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;
    @GetMapping(params = "id")
    public ResponseEntity<?> findById(@RequestParam("id") final Long id){
        Pedido pedido = pedidoService.findById(id);
        return pedido == null
                ? ResponseEntity.badRequest().body("Registro  não encontrado")
                : ResponseEntity.ok(pedido);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody final PedidoDTO pedidoDTO){
        try{
            this.pedidoService.create(pedidoDTO);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        }catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping(params = "id")
    public ResponseEntity<?> update(@RequestParam("id") final Long id, @RequestBody final PedidoDTO pedidoDTO){
        try{
            this.pedidoService.update(id, pedidoDTO);
            return ResponseEntity.ok("Registro editado com sucesso");
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping(params = "id")
    public ResponseEntity<?> delete(@RequestParam("id") final Long id) {
        try {
            pedidoService.delete(id);
            return ResponseEntity.ok("Registro deletado com sucesso");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getCause());
        }
    }
}
