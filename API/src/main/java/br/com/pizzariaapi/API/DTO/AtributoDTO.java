package br.com.pizzariaapi.api.dto;

import br.com.pizzariaapi.api.entity.Tamanho;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AtributoDTO {
    private Long id;
    private Tamanho tamanho;
    private String descricao;
    private double preco;
}
