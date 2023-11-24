package br.com.pizzariaapi.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
@Table(name = "tb.Produto", schema = "public")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "nome", nullable = false, unique = true)
    private String nome;
    @Column(name = "categoria", nullable = false)
    private String categoria;
    @Column(name = "disponivel", nullable = false)
    private boolean disponivel;
    @Column(name = "tempoPreparo", nullable = false)
    private int tempoPreparo;

}
