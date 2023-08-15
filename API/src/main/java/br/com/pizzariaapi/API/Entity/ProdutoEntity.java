package br.com.pizzariaapi.API.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "tb.Produto",schema = "public")
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "Nome", nullable = false, unique = true)
    private String nome;
    @Column(name = "Descricao", nullable = false)
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "Tamanho_ID")
    private TamanhoEntity tamanhoId;
    @ManyToMany(mappedBy = "produtos")
    private List<PedidoEntity> pedido = new ArrayList<>();
}
