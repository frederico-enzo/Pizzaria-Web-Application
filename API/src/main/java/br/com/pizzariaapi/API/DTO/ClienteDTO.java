package br.com.pizzariaapi.API.DTO;
import br.com.pizzariaapi.API.Entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class ClienteDTO {
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    private Endereco endereco;
}
