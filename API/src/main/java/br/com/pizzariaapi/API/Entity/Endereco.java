package br.com.pizzariaapi.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "tb_Endereços",schema = "public")
public class Endereco {
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
    @Column(name = "Cep", nullable = false)
    private String cep;
}
