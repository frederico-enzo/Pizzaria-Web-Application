package br.com.pizzariaapi.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    @ManyToMany
    @JoinTable(
            name = "produto_ingredientes",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id")
    )
    private List<Sabor> sabors;
    @ManyToOne
    @JoinColumn(name = "atributo_id")
    private Atributo atributoEspecifico;
}
