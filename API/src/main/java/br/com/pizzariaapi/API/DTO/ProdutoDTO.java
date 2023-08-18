package br.com.pizzariaapi.API.DTO;

import br.com.pizzariaapi.API.Entity.Atributo;
import br.com.pizzariaapi.API.Entity.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class ProdutoDTO {
    private Long id;
    private String nome;
    private String categoria;
    private String imagemUrl;
    private boolean disponivel;
    private int tempoPreparo;
    private List<Ingrediente> ingredientes;
    private List<String> opcoesPersonalizadas;
    private Atributo atributoEspecifico;
}
