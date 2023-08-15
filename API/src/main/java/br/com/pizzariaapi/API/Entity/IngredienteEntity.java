package br.com.pizzariaapi.API.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "tb.Ingrediente",schema = "public")
public class IngredienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "Name", nullable = false, unique = true)
    private String nome;
    @ManyToMany(mappedBy = "ingredientes")
    private List<SaborEntity> sabores = new ArrayList<>();
}
