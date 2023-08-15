package br.com.pizzariaapi.API.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    @Column(name = "Numereo", nullable = false)
    private Integer numereo;
}
