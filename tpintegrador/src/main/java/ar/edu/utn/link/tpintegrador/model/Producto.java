package ar.edu.utn.link.tpintegrador.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producto {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String nombre;
	private double precio;
	private double anio;

	public Producto(String nombre, double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void aplicarDescuento(double descuento) {
		precio = precio - descuento;
	}
	

	public double getAnio() {
		return anio;
	}

	public void setAnio(double anio) {
		this.anio = anio;
	}

	public Producto() {
		super();
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", anio=" + anio + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public Producto(String nombre, double precio, double anio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.anio = anio;
	}
	

}
