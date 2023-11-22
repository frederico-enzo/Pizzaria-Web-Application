package br.com.pizzariaapi.api.dto;

import br.com.pizzariaapi.api.entity.Tamanho;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class PropriedadeDTO {
    private Long id;
    private Tamanho tamanho;
    private String descricao;
    private float preco;
}
