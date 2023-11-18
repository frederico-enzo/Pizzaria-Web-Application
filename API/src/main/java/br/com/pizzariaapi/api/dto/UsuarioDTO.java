package br.com.pizzariaapi.api.dto;

import br.com.pizzariaapi.api.entity.Endereco;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class UsuarioDTO {

    private Long id;
    @NotBlank(message = "O username não pode estar em branco e deve ser fornecido.")
    private String username;
    @NotBlank(message = "O password não pode estar em branco e deve ser fornecido.")
    private String password;
    @NotBlank(message = "O cpf não pode estar em branco e deve ser fornecido.")
    private String cpf;
    private Endereco endereco;
}
