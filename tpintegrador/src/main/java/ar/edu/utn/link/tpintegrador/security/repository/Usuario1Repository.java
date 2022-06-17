package ar.edu.utn.link.tpintegrador.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.link.tpintegrador.security.entity.Usuario1;
@Repository
public interface Usuario1Repository extends JpaRepository<Usuario1, Integer>{

	 Optional<Usuario1> findByNombreUsuario(String nombreUsuario);
	    boolean existsByNombreUsuario(String nombreUsuario);
	    boolean existsByEmail(String email);
}
