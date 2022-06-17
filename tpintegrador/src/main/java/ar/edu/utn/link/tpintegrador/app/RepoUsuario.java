package ar.edu.utn.link.tpintegrador.app;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.link.tpintegrador.model.Usuario;
import ar.edu.utn.link.tpintegrador.security.entity.Usuario1;

//@RepositoryRestResource(path = "usuarios", excerptProjection = 	UsuarioDTO.class)
@Repository
public interface RepoUsuario extends JpaRepository<Usuario1, Integer> {

	Optional<Usuario1> findByNombre(String nombre);
	boolean existsByNombre(String nombre);

}
