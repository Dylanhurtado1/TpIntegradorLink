package ar.edu.utn.link.tpintegrador.dtos;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.link.tpintegrador.model.Producto;

public interface UsuarioDTO {

	String getNombre();
	
	@Value("#{target.productos}") //ACA SI VA PORQUE EL USUARIO TIENE UNA LISTA DE PRODUCTOS
	List<Producto> getProductos();
	
	@Value("#{target.promocion}") //ACA SI VA PORQUE EL USUARIO TIENE UNA LISTA DE PRODUCTOS
	List<Producto> getPromocion();
	
}
