package br.com.pizzariaapi.api.dto;
import br.com.pizzariaapi.api.entity.Item;
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
