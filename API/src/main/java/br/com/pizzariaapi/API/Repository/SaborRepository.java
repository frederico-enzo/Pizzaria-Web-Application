package br.com.pizzariaapi.API.Repository;
import br.com.pizzariaapi.API.Entity.SaborEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaborRepository extends JpaRepository<SaborEntity,Long> {
}
