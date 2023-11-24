    package br.com.pizzariaapi.api.entity;

    import jakarta.persistence.*;
    import lombok.Getter;
    import lombok.Setter;

    import java.util.ArrayList;
    import java.util.List;

    @Entity
    @Getter
    @Setter
    @Table(name = "pedidos")
    public class Pedido {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, unique = true)
        private Long id;
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "cliente_id")
        private Cliente cliente;
        @Column(name = "valorTotal")
        private double valorTotal;
        @OneToMany(fetch = FetchType.EAGER, mappedBy = "pedido")
        private List<Item> items = new ArrayList<>();
        @Column(name = "ativo")
        private boolean ativo;

        @PrePersist
        public void calcularValorTotal() {
            double total = 0.0;
            for (Item item : items) {
                if (item.getAtributoEspecifico() != null) {
                    total += item.getAtributoEspecifico().getPreco() * item.getQuantidade();
                }
            }
            this.valorTotal = total;
        }


    }
