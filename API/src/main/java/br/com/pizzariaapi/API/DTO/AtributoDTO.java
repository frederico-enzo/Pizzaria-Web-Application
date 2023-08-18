package br.com.pizzariaapi.API.DTO;

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
