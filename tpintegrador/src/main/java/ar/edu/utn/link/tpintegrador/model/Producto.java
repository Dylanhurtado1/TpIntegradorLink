package ar.edu.utn.link.tpintegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ar.edu.utn.link.tpintegrador.security.entity.Usuario1;

@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String nombre;
	private Float precio;
	@ManyToOne // un producto tiene muchos vendedores
	private Usuario1 usuario;
	
	

	


	public Producto(String nombre, Float precio, Usuario1 usuario) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.usuario = usuario;
	}


	public Usuario1 getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario1 usuario) {
		this.usuario = usuario;
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
