package br.com.pizzariaapi.API.Repository;

import br.com.pizzariaapi.API.Entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity,Long> {
}
