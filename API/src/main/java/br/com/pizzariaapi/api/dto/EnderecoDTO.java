package br.com.pizzariaapi.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class EnderecoDTO {
    private Long id;
    private String rua;
    private String bairro;
    private Integer numero;
    private String cep;
}
