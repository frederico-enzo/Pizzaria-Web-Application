package br.com.pizzariaapi.API.Repository;

import br.com.pizzariaapi.API.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}
