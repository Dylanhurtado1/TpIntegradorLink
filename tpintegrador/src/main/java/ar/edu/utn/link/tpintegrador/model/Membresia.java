package ar.edu.utn.link.tpintegrador.model;

import ar.edu.utn.link.tpintegrador.app.Promocion;

public class Membresia implements Promocion{
	String nombre;
	double descuento;
	
	 public void aplicarDescuento(Producto producto) {
	    	
	    	producto.aplicarDescuento(descuento);
	    }
}
