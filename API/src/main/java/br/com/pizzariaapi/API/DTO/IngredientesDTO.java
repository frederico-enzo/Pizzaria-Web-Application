package br.com.pizzariaapi.API.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class IngredientesDTO {
    private Long id;
    private String sabor;
    private List<String> ingrediente;
}
