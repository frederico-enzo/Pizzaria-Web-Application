package br.com.pizzariaapi.API.DTO;

import br.com.pizzariaapi.API.Entity.SaborEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class IngredienteDTO {
    private Long id;
    private String nome;
    private List<SaborEntity> sabores = new ArrayList<>();
}
