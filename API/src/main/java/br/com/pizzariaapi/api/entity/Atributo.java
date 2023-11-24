package br.com.pizzariaapi.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "tb.Atributo", schema = "public")
public class Atributo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Enumerated
    private Tamanho tamanho;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "preco")
    private double preco;

    public Atributo(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public Atributo() {
    }
}
