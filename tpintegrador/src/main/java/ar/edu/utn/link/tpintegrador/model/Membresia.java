package ar.edu.utn.link.tpintegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Membresia extends Promocion1{//implements Promocion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	String nombre;
	double descuento;

	@Override
	public void aplicarDescuento(Producto producto) {

		producto.aplicarDescuento(descuento);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public Membresia(String nombre, double descuento) {
		super();
		this.nombre = nombre;
		this.descuento = descuento;
	}

	public Membresia() {
		super();
	}
	
	
}
