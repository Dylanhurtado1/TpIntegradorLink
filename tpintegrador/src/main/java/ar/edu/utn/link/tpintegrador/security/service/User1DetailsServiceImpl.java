package ar.edu.utn.link.tpintegrador.security.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.edu.utn.link.tpintegrador.security.entity.Usuario1;
import ar.edu.utn.link.tpintegrador.security.entity.UsuarioPrincipal;

@Service
public class User1DetailsServiceImpl implements UserDetailsService {

	@Autowired
	Usuario1Service usuarioService;

	 // Convierte un usuario en UsuarioPrincipal, con el UsuarioPrinciapl matchea la
	
	@Override// seguridad de Spring
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
		Usuario1 usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
		return UsuarioPrincipal.build(usuario);
	}

	
}
