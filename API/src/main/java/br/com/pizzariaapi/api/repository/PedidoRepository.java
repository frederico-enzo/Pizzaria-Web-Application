package br.com.pizzariaapi.api.repository;

import br.com.pizzariaapi.api.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
