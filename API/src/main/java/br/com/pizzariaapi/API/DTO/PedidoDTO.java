package br.com.pizzariaapi.API.DTO;
import br.com.pizzariaapi.API.Entity.Item;
import br.com.pizzariaapi.API.Entity.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class PedidoDTO {
    private Long id;
    private ClienteDTO cliente;
    private double valorTotal;
    private List<Item> items;

}
