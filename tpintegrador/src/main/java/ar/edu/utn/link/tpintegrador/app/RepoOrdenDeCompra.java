package ar.edu.utn.link.tpintegrador.app;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.link.tpintegrador.model.OrdenDeCompra;

@RepositoryRestResource(path = "ordenesDeCompra")
public interface RepoOrdenDeCompra extends PagingAndSortingRepository<OrdenDeCompra, Integer> {

	Optional<OrdenDeCompra> findByNombre(String nombre);

}
