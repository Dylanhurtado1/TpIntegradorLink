package ar.edu.utn.link.tpintegrador.app;

import org.springframework.data.repository.PagingAndSortingRepository;

import ar.edu.utn.link.tpintegrador.model.Cliente;

public interface RepoCliente extends PagingAndSortingRepository<Cliente, Integer> {

	
	
}
