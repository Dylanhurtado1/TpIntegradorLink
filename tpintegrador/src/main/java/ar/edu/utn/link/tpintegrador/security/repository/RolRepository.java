package ar.edu.utn.link.tpintegrador.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.link.tpintegrador.security.entity.Rol;
import ar.edu.utn.link.tpintegrador.security.enums.RolNombre;
@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
	Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
