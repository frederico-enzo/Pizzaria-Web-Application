package br.com.pizzariaapi.api.repository;

import br.com.pizzariaapi.api.entity.Propriedade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropriedadeRepository extends JpaRepository<Propriedade,Long> {
}
