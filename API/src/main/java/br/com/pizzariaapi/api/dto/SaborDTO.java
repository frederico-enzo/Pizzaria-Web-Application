package br.com.pizzariaapi.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class SaborDTO {
    private Long id;
    private String nome;
    private String descricao;
}
