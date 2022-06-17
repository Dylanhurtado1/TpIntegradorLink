package ar.edu.utn.link.tpintegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import ar.edu.utn.link.tpintegrador.security.entity.Usuario1;

@Entity
public class OrdenDeCompra { // voy a poner a un producto
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@OneToOne
	private Usuario1 usuario;

	// @ManyToMany
	// private Collection<Producto> productos = new ArrayList<>();

	@OneToOne
	private Producto producto;

	private double precioFinal;

	public OrdenDeCompra() {
		super();
	}

	public OrdenDeCompra(Usuario1 usuario, Producto producto, double precioFinal) {
		super();
		this.usuario = usuario;
		this.producto = producto;
		this.precioFinal = precioFinal;
	}

	/*
	 * public OrdenDeCompra(Usuario usuario, Collection<Producto> productos) {
	 * super(); this.usuario = usuario; this.productos = productos; }
	 */

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario1 getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario1 usuario) {
		this.usuario = usuario;
	}

	public double getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(double precioFinal) {
		this.precioFinal = precioFinal;
	}

}
