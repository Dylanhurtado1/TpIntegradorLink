package ar.edu.utn.link.tpintegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String nombre;
	private Float precio;
	@ManyToOne//un producto tiene muchos vendedores
	private Vendedor vendedor;
	private String nombreVendedor;

	public Producto(String nombre, Float precio, Vendedor vendedor, String nombreVendedor) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.vendedor = vendedor;
		this.nombreVendedor = nombreVendedor;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public String getNombreVendedor() {
		return nombreVendedor;
	}

	public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
	}

	public Producto(String nombre, Float precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public void aplicarDescuento(Float descuento) {
		precio = precio - descuento;
	}



	public Producto() {
		super();
	}

//	@Override
//	public String toString() {
//		return "Producto [nombre=" + nombre + ", anio=" + anio + "]";
//	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(nombre);
//	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
	// if (getClass() != obj.getClass())
	// return false;
	// Producto other = (Producto) obj;
	// return Objects.equals(nombre, other.nombre);
	// }




}
