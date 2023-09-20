package br.com.pizzariaapi.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class SaborDTO {
    private Long id;
    private String nome;
    private List<String> componentes;
}
