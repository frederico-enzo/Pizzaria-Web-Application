package br.com.pizzariaapi.API.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
@Entity
@Getter @Setter
@Table(name = "tb.Tamanho",schema = "public")
public class TamanhoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "Medida", nullable = false)
    private String medida;
    @Column(name = "Preço", nullable = false)
    private BigDecimal preco;
}
