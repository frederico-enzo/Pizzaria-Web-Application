package br.com.pizzariaapi.api.repository;

import br.com.pizzariaapi.api.entity.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente,Long> {
}
