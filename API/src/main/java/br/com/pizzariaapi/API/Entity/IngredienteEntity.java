package br.com.pizzariaapi.API.Entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "tb.Ingrediente",schema = "public")
public class IngredienteEntity {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

}
