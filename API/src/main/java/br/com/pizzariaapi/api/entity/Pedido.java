package br.com.pizzariaapi.api.entity;

import br.com.pizzariaapi.api.dto.UsuarioDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;
    @Column(name = "valorTotal")
    private double valorTotal;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pedido")
    private List<Item> items = new ArrayList<>();
    @Column(name = "ativo")
    private boolean ativo;
    @PrePersist
    public void calcularValorTotal() {
        double total = 0.0;
        for (Item item : items) {
            if (item.getPropriedade() != null) {
                total += item.getPropriedade().getPreco() * item.getQuantidade();
            }
        }
        this.valorTotal = total;
    }
}