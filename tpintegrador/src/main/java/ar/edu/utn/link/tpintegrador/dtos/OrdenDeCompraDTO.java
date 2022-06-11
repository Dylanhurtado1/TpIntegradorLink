package ar.edu.utn.link.tpintegrador.dtos;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.link.tpintegrador.model.Producto;

public interface OrdenDeCompraDTO {

	String getNombre();

	@Value("#{target.productos}")
	List<Producto> getProductos();

	@Value("#{target.productos.size()}")
	int getCantProductos();

	@Value("#{target.cliente.getNombre()}")
	String getNombreCliente();

	@Value("#{target.vendedor.getNombre()}")
	String getNombreVendedor();

}
