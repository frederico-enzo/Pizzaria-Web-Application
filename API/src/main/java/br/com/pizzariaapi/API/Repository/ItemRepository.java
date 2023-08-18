package br.com.pizzariaapi.API.Repository;

import br.com.pizzariaapi.API.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
