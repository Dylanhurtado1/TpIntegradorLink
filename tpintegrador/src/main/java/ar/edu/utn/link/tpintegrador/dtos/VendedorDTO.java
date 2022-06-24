package ar.edu.utn.link.tpintegrador.dtos;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.link.tpintegrador.model.Producto;


public interface VendedorDTO {

	String getNombre();

	String getApellido();

	@Value("#{target.nombre} #{target.apellido}")
	String getNombreCompleto();

	@Value("#{target.productos.size()}")
	int getCantProductos();

	@Value("#{target.productos}")
	List<Producto> getProductos();

	

}
