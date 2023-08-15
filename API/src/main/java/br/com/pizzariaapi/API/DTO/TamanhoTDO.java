package br.com.pizzariaapi.API.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.math.BigDecimal;
@Data
@AllArgsConstructor
public class TamanhoTDO {
    private Long id;
    private String medida;
    private BigDecimal preco;
}
