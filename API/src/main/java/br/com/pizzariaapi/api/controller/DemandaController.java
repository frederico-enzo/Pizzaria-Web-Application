package br.com.pizzariaapi.api.controller;

import br.com.pizzariaapi.api.dto.DemandaDTO;
import br.com.pizzariaapi.api.service.DemandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demandas")
public class DemandaController {
    @Autowired
    private DemandaService service;
    @GetMapping("/find")
    public ResponseEntity<DemandaDTO> findById(@RequestParam Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<DemandaDTO>> findAll(){
        return ResponseEntity.ok(this.service.findAll());
    }
    @PostMapping("/create")
    public ResponseEntity<DemandaDTO> post(@RequestBody DemandaDTO itemDTO) {
        return ResponseEntity.ok(service.post(itemDTO));
    }
    @PutMapping("/update")
    public ResponseEntity<DemandaDTO> put(@RequestParam Long id, @RequestBody DemandaDTO itemDTO) {
        return  ResponseEntity.ok(service.put(itemDTO, id));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

