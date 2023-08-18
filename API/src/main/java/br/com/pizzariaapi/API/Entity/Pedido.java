package br.com.pizzariaapi.API.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)  // Usando LAZY loading aqui
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @Column(name = "valorTotal")
    private double valorTotal;
;
}
