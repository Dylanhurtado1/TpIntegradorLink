package ar.edu.utn.link.tpintegrador.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class OrdenDeCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@OneToOne
	private Usuario usuario;
	
//	@OneToMany
//	private Collection<Producto> productos;
	
	@OneToOne
	private Producto producto;
	
	private double precioFinal;

	public OrdenDeCompra() {
		super();
	}

/*	public OrdenDeCompra(Usuario usuario, Collection<Producto> productos) {
		super();
		this.usuario = usuario;
		this.productos = productos;
	} */

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/*
	public Collection<Producto> getProductos() {
		return productos;
	} */

	/*
	public void setProductos(Collection<Producto> productos) {
		this.productos = productos;
	}*/

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public double getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(double precioFinal) {
		this.precioFinal = precioFinal;
	}
	

}
