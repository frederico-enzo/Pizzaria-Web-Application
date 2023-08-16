package br.com.pizzariaapi.API.DTO;
import br.com.pizzariaapi.API.Entity.ClienteEntity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
public class EnderecoDTO {
    private Long id;
    private String rua;
    private String bairro;
    private Integer numero;

}
