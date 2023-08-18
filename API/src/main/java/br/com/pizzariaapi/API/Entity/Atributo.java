package br.com.pizzariaapi.API.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb.Atributo", schema = "public")
public class Atributo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "tamanho")
    private String tamanho;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "preco")
    private double preco;
}
