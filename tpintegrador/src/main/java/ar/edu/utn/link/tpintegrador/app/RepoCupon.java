package ar.edu.utn.link.tpintegrador.app;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.link.tpintegrador.dtos.CuponDTO;
import ar.edu.utn.link.tpintegrador.model.CuponProveedor;
@RepositoryRestResource(path = "cupones",excerptProjection = CuponDTO.class)
public interface RepoCupon extends PagingAndSortingRepository<CuponProveedor, Integer> {

}
