package br.com.pizzariaapi.api.dto;

import br.com.pizzariaapi.api.entity.Atributo;
import br.com.pizzariaapi.api.entity.Pedido;
import br.com.pizzariaapi.api.entity.Sabor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
public class ItemDTO {
    private Long id;
    private ProdutoDTO produto;
    private int quantidade;
    private List<Sabor> sabors;
    private Atributo atributoEspecifico;
    private Pedido pedido;

}
