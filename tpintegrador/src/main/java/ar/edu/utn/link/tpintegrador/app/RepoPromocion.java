package ar.edu.utn.link.tpintegrador.app;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.link.tpintegrador.model.Promocion1;
//@RepositoryRestResource(path = "promociones")
@Repository
public interface RepoPromocion extends JpaRepository<Promocion1, Integer>{//creo q esta ready

	Optional<Promocion1> findByNombre(String nombre);

	boolean existsByNombre(String nombre);
	
	
}
