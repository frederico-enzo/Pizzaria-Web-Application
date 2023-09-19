package br.com.pizzariaapi.api.dto;

import br.com.pizzariaapi.api.entity.Atributo;
import br.com.pizzariaapi.api.entity.Sabor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class ProdutoDTO {
    private Long id;
    private String nome;
    private String categoria;
    private boolean disponivel;
    private int tempoPreparo;
    private List<Sabor> sabors;
    private Atributo atributoEspecifico;
}
