package br.com.pizzariaapi.api.dto;
import br.com.pizzariaapi.api.entity.Endereco;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClienteDTO {
    private Long id;
    private String username;
    private String role;
    private String token;
    private Endereco endereco;
}
