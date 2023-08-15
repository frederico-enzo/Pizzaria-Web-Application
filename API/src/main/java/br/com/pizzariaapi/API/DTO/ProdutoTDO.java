package br.com.pizzariaapi.API.DTO;

import br.com.pizzariaapi.API.Entity.TamanhoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ProdutoTDO {
    private Long id;
    private String nome;
    private String descricao;
    private TamanhoEntity tamanhoId;
}

