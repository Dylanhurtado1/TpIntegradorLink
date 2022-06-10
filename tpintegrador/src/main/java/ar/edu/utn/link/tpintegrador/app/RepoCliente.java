package ar.edu.utn.link.tpintegrador.app;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.link.tpintegrador.dtos.ClienteDTO;
import ar.edu.utn.link.tpintegrador.model.Cliente;


@RepositoryRestResource(path = "clientes",excerptProjection = ClienteDTO.class)
public interface RepoCliente extends PagingAndSortingRepository<Cliente, Integer> {

	Optional<Cliente> findByNombre(String nombre);
	
}
