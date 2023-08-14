package br.com.pizzariaapi.API.Repository;

import br.com.pizzariaapi.API.Entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity,Long> {

}
