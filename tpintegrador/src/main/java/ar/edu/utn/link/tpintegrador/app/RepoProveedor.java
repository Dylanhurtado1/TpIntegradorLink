package ar.edu.utn.link.tpintegrador.app;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.link.tpintegrador.dtos.ProveedorDTO;
import ar.edu.utn.link.tpintegrador.model.Proveedor;

@RepositoryRestResource(path = "proveedores", excerptProjection = ProveedorDTO.class)
public interface RepoProveedor extends PagingAndSortingRepository<Proveedor, Integer> {

	Optional<Proveedor> findByNombre(String nombre);

}
