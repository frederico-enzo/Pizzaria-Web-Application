package br.com.pizzariaapi.API.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class FuncionarioDTO {
    private Long id;
    private String nome;
    private String telefone;
}
