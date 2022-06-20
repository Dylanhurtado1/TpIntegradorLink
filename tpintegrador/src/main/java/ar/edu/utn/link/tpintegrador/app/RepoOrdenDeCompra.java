package ar.edu.utn.link.tpintegrador.app;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import ar.edu.utn.link.tpintegrador.model.OrdenDeCompra;



//@RepositoryRestResource(path = "ordenesDeCompra")
@Repository
public interface RepoOrdenDeCompra extends JpaRepository<OrdenDeCompra, Integer> {


	Optional<OrdenDeCompra> findByNombre(String nombre);
	
	boolean existsByNombre(String nombre);
	
}
