package br.com.pizzariaapi.api.entity;

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
    private List<Demanda> items = new ArrayList<>();
    @Column(name = "ativo")
    private boolean ativo;

}