package br.com.pizzariaapi.API.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class ClienteDTO {
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    private List<EnderecoDTO> enderecos = new ArrayList<>();
}
