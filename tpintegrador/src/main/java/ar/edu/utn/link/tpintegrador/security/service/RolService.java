package ar.edu.utn.link.tpintegrador.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.utn.link.tpintegrador.security.entity.Rol;
import ar.edu.utn.link.tpintegrador.security.enums.RolNombre;
import ar.edu.utn.link.tpintegrador.security.repository.RolRepository;

@Service
@Transactional
public class RolService {

	    @Autowired
	    RolRepository rolRepository;

	    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
	        return rolRepository.findByRolNombre(rolNombre);
	    }
	    
	    public Optional<Rol> findByProfile(int profileId){
	        return rolRepository.findById(profileId);
	    }
	    

	    public void save(Rol rol){
	        rolRepository.save(rol);
	    }
}
