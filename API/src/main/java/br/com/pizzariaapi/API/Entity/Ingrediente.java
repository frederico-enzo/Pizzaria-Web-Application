package br.com.pizzariaapi.API.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.ModCheck;

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
    private List<String> ingrediente;
}
