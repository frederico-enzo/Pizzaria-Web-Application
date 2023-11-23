package br.com.pizzariaapi.api.dto;

import br.com.pizzariaapi.api.entity.Item;
import br.com.pizzariaapi.api.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class PedidoDTO {
    private Long id;
    private Usuario cliente;
    private double valorTotal;
    private List<Item> items = new ArrayList<>();
    private boolean ativo;
}
