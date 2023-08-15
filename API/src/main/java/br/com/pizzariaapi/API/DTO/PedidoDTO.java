package br.com.pizzariaapi.API.DTO;

import br.com.pizzariaapi.API.Entity.FuncionarioEntity;
import br.com.pizzariaapi.API.Entity.ProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class PedidoDTO {
    private Long id;
    private Boolean status;
    private Boolean entrega;
    private BigDecimal valorTotal;
    private LocalDateTime tempoPedido;
    private FuncionarioEntity funcionarioId;
    private List<ProdutoEntity> produtoEntityList = new ArrayList<>();
}
