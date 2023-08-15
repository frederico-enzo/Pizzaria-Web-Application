package br.com.pizzariaapi.API.DTO;

import br.com.pizzariaapi.API.Entity.IngredienteEntity;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class SaborDTO {
    private Long id;
    private String nome;
    private List<IngredienteEntity> ingredientes = new ArrayList<>();
}
