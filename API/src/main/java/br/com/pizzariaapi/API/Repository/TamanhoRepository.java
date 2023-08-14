package br.com.pizzariaapi.API.Repository;

import br.com.pizzariaapi.API.Entity.TamanhoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TamanhoRepository extends JpaRepository<TamanhoEntity,Long> {
}
