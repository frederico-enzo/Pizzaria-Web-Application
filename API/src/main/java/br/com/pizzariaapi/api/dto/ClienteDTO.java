package br.com.pizzariaapi.api.dto;
import br.com.pizzariaapi.api.entity.Endereco;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClienteDTO {
    private Long id;
    private String login;
    private String password;
    private Endereco endereco;
}