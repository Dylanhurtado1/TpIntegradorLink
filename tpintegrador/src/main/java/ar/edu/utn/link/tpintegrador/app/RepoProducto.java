package ar.edu.utn.link.tpintegrador.app;

import org.springframework.beans.factory.annotation.Qualifier;

//import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import ar.edu.utn.link.tpintegrador.model.Producto;
//@RepositoryRestResource(path="productos")//esto creo que hay que sacarlo, ahora vemos xD

@Qualifier("jpa3")
public interface RepoProducto extends PagingAndSortingRepository<Producto, Integer> {

	//Optional <Producto> findByNombre(String nombre);
	
	Page<Producto> findAll(Pageable page);
	
	Producto findByNombre(String nombre);
	
    Page<Producto> findByAnio(Integer anio,Pageable page);
	
	Producto findByNombreAndAnio(String nombre,Integer anio);
	
}
