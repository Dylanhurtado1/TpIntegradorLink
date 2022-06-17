package ar.edu.utn.link.tpintegrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.utn.link.tpintegrador.app.RepoUsuario;
import ar.edu.utn.link.tpintegrador.security.entity.Usuario1;

@Service
@Transactional
public class UsuarioService {

	 @Autowired
	 RepoUsuario usuarioRepository;
	
	  public List<Usuario1> list(){
	        return usuarioRepository.findAll();
	    }

	    public Optional<Usuario1> getOne(int id){
	        return usuarioRepository.findById(id);
	    }

	    public Optional<Usuario1> getByNombre(String nombre){
	        return usuarioRepository.findByNombre(nombre);
	    }

	    public void  save(Usuario1 usuario){
	        usuarioRepository.save(usuario);
	    }

	    public void delete(int id){
	        usuarioRepository.deleteById(id);
	    }

	    public boolean existsById(int id){
	        return usuarioRepository.existsById(id);
	    }

	    public boolean existsByNombre(String nombre){
	        return usuarioRepository.existsByNombre(nombre);
	    }
	
}
