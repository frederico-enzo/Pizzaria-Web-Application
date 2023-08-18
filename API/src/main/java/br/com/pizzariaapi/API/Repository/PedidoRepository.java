package br.com.pizzariaapi.API.Repository;

import br.com.pizzariaapi.API.Entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
