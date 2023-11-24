package br.com.pizzariaapi.api.repository;

import br.com.pizzariaapi.api.entity.Atributo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtributoRepository extends JpaRepository<Atributo, Long> {
}
