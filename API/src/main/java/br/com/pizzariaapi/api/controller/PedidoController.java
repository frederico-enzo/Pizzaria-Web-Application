package br.com.pizzariaapi.api.controller;

import br.com.pizzariaapi.api.dto.PedidoDTO;
import br.com.pizzariaapi.api.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;
    @GetMapping("/find")
    public ResponseEntity<PedidoDTO> findById(@RequestParam Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<PedidoDTO>> findAll(){
        return ResponseEntity.ok(this.service.findAll());
    }
    @PostMapping("/create")
    public ResponseEntity<PedidoDTO> post(@RequestBody PedidoDTO pedidoDTO) {
        return ResponseEntity.ok(service.post(pedidoDTO));
    }
    @PutMapping("/update")
    public ResponseEntity<PedidoDTO> put(@RequestParam Long id,@RequestBody  PedidoDTO pedidoDTO) {
        return  ResponseEntity.ok(service.put(id, pedidoDTO));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

