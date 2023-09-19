package br.com.pizzariaapi.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class IngredientesDTO {
    private Long id;
    private String sabor;
    private List<String> ingrediente;
}
