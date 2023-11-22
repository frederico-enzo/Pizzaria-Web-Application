package br.com.pizzariaapi.api.repository;

import br.com.pizzariaapi.api.entity.Tamanho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TamanhoRepository extends JpaRepository<Tamanho,Long> {
}
