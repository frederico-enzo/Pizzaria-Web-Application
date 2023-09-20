package br.com.pizzariaapi.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "tb_Clientes", schema = "public")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "Nome", nullable = false)
    private String nome;

    @Column(name = "Telefone", nullable = false, unique = true)
    private String telefone;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "Senha", nullable = false)
    private String senha;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
}
