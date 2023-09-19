package br.com.pizzariaapi.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


    @Entity
    @Getter
    @Setter
    @Table(name = "tb_item")
    public class Item {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, unique = true)
        private Long id;
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "pedido_id")
        @JsonIgnore
        private Pedido pedido;
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "produto_id")
        private Produto produto;
        @Column(name = "quantidade")
        private int quantidade;
    }
