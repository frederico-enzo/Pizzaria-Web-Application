package br.com.pizzariaapi.API.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "tb.Endereço",schema = "public")
public class EnderecoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "Rua", nullable = false)
    private String rua;
    @Column(name = "Bairro", nullable = false)
    private String bairro;
    @Column(name = "Numero", nullable = false)
    private Integer numero;
    @ManyToMany(mappedBy = "enderecos")
    private Set<ClienteEntity> clientes = new HashSet<>();
}
