package ar.edu.utn.link.tpintegrador.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Carrito {// estoy haciendo esto para que en una orden de Compra esten todos los productos

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
		
	@OneToMany//la lista de productos que tiene un usario
	private Collection<Producto> productos;

	@OneToOne//cada carrito tiene un usuario
	private Usuario usuario;

	public Collection<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Collection<Producto> productos) {
		this.productos = productos;
	}

	public Carrito(Collection<Producto> productos) {
		super();
		this.productos = productos;
	}

	public Carrito() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
