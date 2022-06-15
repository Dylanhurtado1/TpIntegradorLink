package ar.edu.utn.link.tpintegrador.app;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.link.tpintegrador.model.Promocion1;
@RepositoryRestResource(path = "promociones")
public interface RepoPromocion extends PagingAndSortingRepository<Promocion1, Integer>{


	
	
}
