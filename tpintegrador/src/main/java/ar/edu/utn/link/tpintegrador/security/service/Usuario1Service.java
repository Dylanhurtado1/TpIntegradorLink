package ar.edu.utn.link.tpintegrador.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.utn.link.tpintegrador.security.entity.Usuario1;
import ar.edu.utn.link.tpintegrador.security.repository.Usuario1Repository;

@Service
@Transactional
public class Usuario1Service {

	 @Autowired
	    Usuario1Repository usuarioRepository;

	    public Optional<Usuario1> getByNombreUsuario(String nombreUsuario){
	        return usuarioRepository.findByNombreUsuario(nombreUsuario);
	    }

	    public boolean existsByNombreUsuario(String nombreUsuario){
	        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
	    }

	    public boolean existsByEmail(String email){
	        return usuarioRepository.existsByEmail(email);
	    }

	    public void save(Usuario1 usuario){
	        usuarioRepository.save(usuario);
	    }
	
	
	
}
