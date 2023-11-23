package br.com.pizzariaapi.api.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity @Table(name = "tb_propriedade" , schema = "public")
public class Propriedade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "tamanho")
    private Tamanho tamanho;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "preco")
    private float preco;
}
