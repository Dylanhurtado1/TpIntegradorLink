package ar.edu.utn.link.tpintegrador.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ar.edu.utn.link.tpintegrador.security.entity.Rol;
import ar.edu.utn.link.tpintegrador.security.enums.RolNombre;
import ar.edu.utn.link.tpintegrador.security.service.RolService;
@Component
public class CreateRoles implements CommandLineRunner{

	 @Autowired
	    RolService rolService;

	    @Override
	    public void run(String... args) throws Exception {
	      /* Rol rolVendedor = new Rol(RolNombre.ROLE_VENDEDOR);
	        Rol rolUser = new Rol(RolNombre.ROLE_USER);
	        rolService.save(rolVendedor);
	        rolService.save(rolUser); 
	     */    
	    }
}
