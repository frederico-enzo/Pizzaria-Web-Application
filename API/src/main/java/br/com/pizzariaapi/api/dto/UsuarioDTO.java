package br.com.pizzariaapi.api.dto;

import br.com.pizzariaapi.api.entity.Endereco;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class UsuarioDTO {

    private Long id;
    private String username;
    private String password;
    private String cpf;
    private Endereco endereco;
}
