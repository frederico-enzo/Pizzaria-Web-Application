package br.com.pizzariaapi.api.dto;

import br.com.pizzariaapi.api.entity.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemDTO {
    private Long id;
    private ProdutoDTO produto;
    private Pedido pedido;
    private int quantidade;
}
