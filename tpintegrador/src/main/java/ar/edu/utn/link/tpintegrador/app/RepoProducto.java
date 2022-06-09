package ar.edu.utn.link.tpintegrador.app;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.link.tpintegrador.model.Producto;
@RepositoryRestResource(path="productos")
public interface RepoProducto extends PagingAndSortingRepository<Producto, Integer> {

	Optional <Producto> findByNombre(String nombre);
	
	
}
