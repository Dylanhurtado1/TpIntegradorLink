package ar.edu.utn.link.tpintegrador.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Vendedor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nombre;
	private String apellido;

	@OneToMany
	private Collection<Producto> productos;
	@OneToMany // un vendedor tiene muchos proveedores
	private Collection<Proveedor> proveedores;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Vendedor(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Vendedor() {
		super();
	}

	public Collection<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Collection<Producto> productos) {
		this.productos = productos;
	}

	public Collection<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(Collection<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public Vendedor(String nombre, String apellido, Collection<Producto> productos, Collection<Proveedor> proveedores) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.productos = productos;
		this.proveedores = proveedores;
	}

}
