package ar.edu.utn.link.tpintegrador.app;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;


import ar.edu.utn.link.tpintegrador.model.Producto;

//@Qualifier("jpa3")
//@RepositoryRestResource(path = "productos", excerptProjection = ProductoDTO.class)
@Repository
public interface RepoProducto extends JpaRepository<Producto, Integer> {

	Optional<Producto> findByNombre(String nombre);

	boolean existsByNombre(String nombre);

}
