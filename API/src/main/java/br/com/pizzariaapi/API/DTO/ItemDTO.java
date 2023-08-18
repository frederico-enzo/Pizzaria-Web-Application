package br.com.pizzariaapi.API.DTO;

import br.com.pizzariaapi.API.Entity.Pedido;
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
