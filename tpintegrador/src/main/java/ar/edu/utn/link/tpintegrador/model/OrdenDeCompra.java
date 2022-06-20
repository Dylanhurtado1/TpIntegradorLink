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
	private String nombreUsuario;
	private String nombreVendedor;
	private String nombreProducto;

	private String nombre;

	public OrdenDeCompra(Usuario1 usuario, String nombreUsuario, String nombreVendedor, String nombreProducto,
			String nombre, Producto producto, double precioFinal) {
		super();
		this.usuario = usuario;
		this.nombreUsuario = nombreUsuario;
		this.nombreVendedor = nombreVendedor;
		this.nombreProducto = nombreProducto;
		this.nombre = nombre;
		this.producto = producto;
		this.precioFinal = precioFinal;
	}

	// @ManyToMany
	// private Collection<Producto> productos = new ArrayList<>();

	public String getNombreVendedor() {
		return nombreVendedor;
	}

	public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
	}

	public String getNombre() {
		return nombre;
	}

	public OrdenDeCompra(Usuario1 usuario, String nombreUsuario, String nombreProducto, String nombre,
			Producto producto, double precioFinal) {
		super();
		this.usuario = usuario;
		this.nombreUsuario = nombreUsuario;
		this.nombreProducto = nombreProducto;
		this.nombre = nombre;
		this.producto = producto;
		this.precioFinal = precioFinal;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

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

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

}
