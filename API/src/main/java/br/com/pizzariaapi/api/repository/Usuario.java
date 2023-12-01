package br.com.pizzariaapi.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface Usuario extends JpaRepository<Usuario, Long> {
    UserDetails findByUsername(String username);

}
