package br.com.pizzariaapi.API.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemDTO {
    private Long id;
    private ProdutoDTO produto;
    private int quantidade;
}
