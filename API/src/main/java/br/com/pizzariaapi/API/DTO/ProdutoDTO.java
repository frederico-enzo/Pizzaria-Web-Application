package br.com.pizzariaapi.api.dto;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProdutoDTO {
    private Long id;
    private String nome;
    private String categoria;
    private boolean disponivel;
    private int tempoPreparo;
}
