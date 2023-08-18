package br.com.pizzariaapi.API.Repository;

import br.com.pizzariaapi.API.Entity.Atributo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtributoRepository extends JpaRepository<Atributo, Long> {
}
