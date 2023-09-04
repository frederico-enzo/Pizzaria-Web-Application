package br.com.pizzariaapi.API.Repository;

import br.com.pizzariaapi.API.Entity.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente,Long> {
}