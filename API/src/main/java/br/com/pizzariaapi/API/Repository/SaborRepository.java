package br.com.pizzariaapi.api.repository;

import br.com.pizzariaapi.api.entity.Sabor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaborRepository extends JpaRepository<Sabor,Long> {
}
