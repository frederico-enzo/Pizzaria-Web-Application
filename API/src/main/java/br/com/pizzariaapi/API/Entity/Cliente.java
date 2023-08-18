package br.com.pizzariaapi.API.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "tb.Clientes", schema = "public")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "Nome", nullable = false)
    private String nome;
    @Column(name = "Telefone", nullable = false, unique = true)
    private String telefone;
    @Column(name = "E-mail", nullable = false, unique = true)
    private String email;
    @Column(name = "Senha", nullable = false)
    private String senha;
    @Column(name = "enderecos", nullable = false)
    @OneToMany(cascade = CascadeType.MERGE)
    private List<Endereco> enderecos = new ArrayList<>();
}
