package br.com.pizzariaapi.api.dto;
import br.com.pizzariaapi.api.entity.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter @Setter
public class PedidoDTO {
    private Long id;
    private ClienteDTO cliente;
    private double valorTotal;
    private List<Item> items;

}
