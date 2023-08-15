package br.com.pizzariaapi.API.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "tb.Pedido",schema = "public")
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "status", nullable = false)
    private Boolean status;
    @Column(name = "entrega", nullable = false)
    private Boolean entrega;
    @Column(name = "valorTotal", nullable = false)
    private BigDecimal valorTotal;
    @Column(name = "tempoPedido", nullable = false)
    private LocalDateTime tempoPedido;
    @ManyToOne
    @JoinColumn(name = "Funcionario_Id", unique = true)
    private FuncionarioEntity funcionarioId;
    @ManyToMany
    @JoinTable(
            name = "pedido_produto",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<ProdutoEntity> produtos = new ArrayList<>();
}
