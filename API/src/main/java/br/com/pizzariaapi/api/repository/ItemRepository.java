package br.com.pizzariaapi.api.repository;

import br.com.pizzariaapi.api.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
