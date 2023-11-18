package br.com.pizzariaapi.api.repository;

import br.com.pizzariaapi.api.entity.Usuario;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

@Entity
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
