package ar.edu.utn.link.tpintegrador.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import ar.edu.utn.link.tpintegrador.security.entity.Usuario1;

@Entity
public class Vendedor { // voy a modificar esto
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nombre;
	private String apellido;

	@OneToMany
	private Collection<Producto> productosAVender;
	//@OneToMany // un vendedor tiene muchos proveedores
	//private Collection<Proveedor> proveedores;

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

	
	public Vendedor() {
		super();
	}

	public Vendedor(Collection<Producto> productosAVender) {
		super();
		this.productosAVender = productosAVender;
	}

	public Collection<Producto> getProductos() {
		return productosAVender;
	}

	public void setProductos(Collection<Producto> productos) {
		this.productosAVender = productos;
	}

	public Vendedor(String nombre, String apellido, Collection<Producto> productosAVender) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.productosAVender = productosAVender;
	}

	

}
