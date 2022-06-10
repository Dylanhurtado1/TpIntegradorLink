package ar.edu.utn.link.tpintegrador.app;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.link.tpintegrador.dtos.ProductoDTO;
import ar.edu.utn.link.tpintegrador.model.Producto;


//@Qualifier("jpa3")
@RepositoryRestResource(path = "productos",excerptProjection = ProductoDTO.class)
public interface RepoProducto extends PagingAndSortingRepository<Producto, Integer> {

	
	
	Optional<Producto> findByNombre(String nombre);
	
	
}
