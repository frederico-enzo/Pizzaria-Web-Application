package br.com.pizzariaapi.api.repository;

import br.com.pizzariaapi.api.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    UserDetails findByUsername(String username);
}
