package br.com.pizzariaapi.api.repository;

import br.com.pizzariaapi.api.entity.Demanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandaRepository extends JpaRepository<Demanda,Long> {
}
