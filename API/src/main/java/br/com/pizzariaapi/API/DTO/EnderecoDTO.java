package br.com.pizzariaapi.api.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class EnderecoDTO {
    private Long id;
    private String rua;
    private String bairro;
    private Integer numero;
    private String cep;

}
