package br.com.pizzariaapi.api.repository;

import br.com.pizzariaapi.api.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}
