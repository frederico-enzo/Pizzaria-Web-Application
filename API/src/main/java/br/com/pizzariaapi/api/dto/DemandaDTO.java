package br.com.pizzariaapi.api.dto;

import br.com.pizzariaapi.api.entity.Produto;
import br.com.pizzariaapi.api.entity.Propriedade;
import br.com.pizzariaapi.api.entity.Sabor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class DemandaDTO {
    private Long id;
    private Produto produto;
    private int quantidade;
    private List<Sabor> sabors;
    private Propriedade propriedade;
}
