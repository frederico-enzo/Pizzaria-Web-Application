package br.com.pizzariaapi.API.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IngredientesDTO {
    private Long id;
    private String ingrediente;
}
