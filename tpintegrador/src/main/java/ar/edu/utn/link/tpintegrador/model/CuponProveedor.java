package ar.edu.utn.link.tpintegrador.model;

import ar.edu.utn.link.tpintegrador.app.Promocion;

public class CuponProveedor implements Promocion {
	String nombre;
	double descuento;

	public void aplicarDescuento(Producto producto) {

		producto.aplicarDescuento(descuento);
	}

	public CuponProveedor(String nombre, double descuento) {
		super();
		this.nombre = nombre;
		this.descuento = descuento;
	}

}
