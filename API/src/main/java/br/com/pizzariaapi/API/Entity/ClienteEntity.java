package br.com.pizzariaapi.API.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "tb.Cliente", schema = "public")
public class ClienteEntity {
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
    @OneToMany
    @JoinColumn(name = "Enderecos", nullable = false)
    private List<EnderecoEntity> enderecos = new ArrayList<>();

}
