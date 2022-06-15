package ar.edu.utn.link.tpintegrador.app;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.link.tpintegrador.model.Carrito;

@RepositoryRestResource(path = "carrito")
public interface RepoCarrito extends PagingAndSortingRepository<Carrito, Integer> {

	
	
	
}
