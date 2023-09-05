package br.com.pizzariaapi.API.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class IngredientesDTO {
    private Long id;
    private String sabor;
    private List<String> ingrediente;
}
