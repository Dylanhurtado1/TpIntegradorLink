package ar.edu.utn.link.tpintegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import ar.edu.utn.link.tpintegrador.security.entity.Usuario1;

@Entity
public class OrdenDeCompra { // voy a poner a un producto
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne // muchas ordenes de compra pueden tener un usuario -> pruebo desde angular
	private Usuario1 comprador;
	private double precioFinal;
	//private String nombre;
	@ManyToOne
	private Producto producto;
	private String nombreUsuario;
	private String nombreProducto;
	
	
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

	private double precioFinalEnDolares;

	

	public OrdenDeCompra(Usuario1 comprador, double precioFinal, Producto producto, String nombreUsuario,
			String nombreProducto, double precioFinalEnDolares) {
		super();
		this.comprador = comprador;
		this.precioFinal = precioFinal;
		this.producto = producto;
		this.nombreUsuario = nombreUsuario;
		this.nombreProducto = nombreProducto;
		this.precioFinalEnDolares = precioFinalEnDolares;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public double getPrecioFinalEnDolares() {
		return precioFinalEnDolares;
	}

	public void setPrecioFinalEnDolares(double precioFinalEnDolares) {
		this.precioFinalEnDolares = precioFinalEnDolares;
	}


	public Usuario1 getComprador() {
		return comprador;
	}

	public void setComprador(Usuario1 comprador) {
		this.comprador = comprador;
	}

	

	public OrdenDeCompra() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(double precioFinal) {
		this.precioFinal = precioFinal;
	}

}
