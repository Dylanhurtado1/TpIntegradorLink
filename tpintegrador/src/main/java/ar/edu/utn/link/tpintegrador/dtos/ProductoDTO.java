package ar.edu.utn.link.tpintegrador.dtos;

import org.springframework.beans.factory.annotation.Value;

public interface ProductoDTO {
	
	String getNombre();
	
	Double getPrecio();
	
	//@Value("#{target.vendedor.getNombre()}")
	//String getNombreVendedor();
	
}
