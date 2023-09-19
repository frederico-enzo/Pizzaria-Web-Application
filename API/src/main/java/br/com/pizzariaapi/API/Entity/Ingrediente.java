package br.com.pizzariaapi.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@Table(name = "tb.Ingredientes", schema = "public")
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "sabor", nullable = false, unique = true)
    private String sabor;
    @Column(name = "ingrediente", nullable = false, unique = true)
    private List<String> componentes;
}
