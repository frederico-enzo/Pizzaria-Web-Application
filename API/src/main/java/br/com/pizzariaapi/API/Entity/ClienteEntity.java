package br.com.pizzariaapi.API.Entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "tb.Cliente", schema = "public")
public class ClienteEntity {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

}
