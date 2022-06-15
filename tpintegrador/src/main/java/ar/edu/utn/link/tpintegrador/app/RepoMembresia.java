package ar.edu.utn.link.tpintegrador.app;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.link.tpintegrador.dtos.MembresiaDTO;
import ar.edu.utn.link.tpintegrador.model.Membresia;
@RepositoryRestResource(path = "membresias",excerptProjection = MembresiaDTO.class)
public interface RepoMembresia extends PagingAndSortingRepository<Membresia, Integer> {

}
