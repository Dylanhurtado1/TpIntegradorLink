package ar.edu.utn.link.tpintegrador.dtos;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.link.tpintegrador.model.Producto;
import ar.edu.utn.link.tpintegrador.model.Usuario;

public interface ClienteDTO {

	String getNombre();

	String getApellido();
	
	@Value("#{target.productos}")
	List<Producto> getProductos();
	
	@Value("#{target.usuario}")
	Usuario getUsuario();
}
