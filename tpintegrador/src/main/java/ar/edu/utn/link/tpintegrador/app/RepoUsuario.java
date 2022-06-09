package ar.edu.utn.link.tpintegrador.app;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.link.tpintegrador.model.Usuario;
@RepositoryRestResource(path="usuarios")
public interface RepoUsuario extends PagingAndSortingRepository<Usuario, Integer> {

	Optional<Usuario> findByNombre(String nombre);
	
}
