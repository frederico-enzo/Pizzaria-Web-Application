package br.com.pizzariaapi.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AtributoDTO {
    private Long id;
    private String tamanho;
    private String descricao;
    private double preco;
}
