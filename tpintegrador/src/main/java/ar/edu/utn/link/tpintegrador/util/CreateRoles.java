package ar.edu.utn.link.tpintegrador.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ar.edu.utn.link.tpintegrador.model.CuponProveedor;
import ar.edu.utn.link.tpintegrador.model.Producto;
import ar.edu.utn.link.tpintegrador.model.Promocion1;
import ar.edu.utn.link.tpintegrador.security.entity.Rol;
import ar.edu.utn.link.tpintegrador.security.entity.Usuario1;
import ar.edu.utn.link.tpintegrador.security.enums.RolNombre;
import ar.edu.utn.link.tpintegrador.security.service.RolService;
import ar.edu.utn.link.tpintegrador.service.PromocionService;
import ar.edu.utn.link.tpintegrador.service.UsuarioService;
@Component
public class CreateRoles implements CommandLineRunner{

	    @Autowired
	    RolService rolService;

	    @Autowired
	    PromocionService promoService;
	    @Autowired
	    UsuarioService usuarioService;

	    @Override
	    public void run(String... args) throws Exception {//tengo que crear asi promociones
	    Rol rolVendedor = new Rol(RolNombre.ROLE_VENDEDOR);
	    Rol rolUser = new Rol(RolNombre.ROLE_USER);
	    rolService.save(rolVendedor);
	    rolService.save(rolUser);  
	   
	    
	/*    Promocion1 promocion1 = new CuponProveedor(100);
	    Promocion1 promocion2 = new CuponProveedor(200);
	    Usuario1 usuario = new Usuario1("Dylan","usuario","usuario@gmail.com","usuario",promocion1,2);
	    Usuario1 usuario2 = new Usuario1("Rodrigo","usuario2","usuario2@gmail.com","usuario2",promocion2,2);
	    Usuario1 vendedor = new Usuario1("Jose","vendedor","vendedor@gmail.com","vendedor",1);//1 para decirq es vendedor
	    Usuario1 vendedor2 = new Usuario1("Pepe","vendedor2","vendedor2@gmail.com","vendedor2",1);
//	    Producto producto = new Producto("leche",100.0,vendedor); 
	   
	    
	    promoService.save(promocion2);
	    promoService.save(promocion1);
	    usuarioService.save(usuario);
	    usuarioService.save(usuario2);
	    usuarioService.save(vendedor);
	    usuarioService.save(vendedor2); */
	    } 
	    
	    
}
