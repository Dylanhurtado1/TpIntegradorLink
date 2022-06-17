package ar.edu.utn.link.tpintegrador.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String nombre;

	private String password;
	@OneToMany
	private Collection<Producto> productos;

	@OneToMany
	private Collection<Promocion1> promociones;

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

	public Usuario(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public void comprar(Producto producto) {
		this.productos.add(producto);
	}

	//public void aplicarDescuento(Producto producto) {
	//	promocion.aplicarDescuento(producto);
	//}

	public void comprarCarrito(Carrito carrito) {
		Collection<Producto> productosDeCarrito = carrito.getProductos();// productos del carrito
		this.productos.addAll(productosDeCarrito); // creo que ahi se agregan
	}

	public Usuario() {
		super();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public double obtenerDescuentoDePromociones() {
		double descuentoFinal = 0;
		for(Promocion1 p:promociones) {
		descuentoFinal = descuentoFinal + p.getDescuento();
		}
		return descuentoFinal;
	}

	//public Promocion1 getPromocion() {
	//	return promocion;
	//}

	//public void setPromocion(Promocion1 promocion) {
	//	this.promocion = promocion;
	//}
	
	

	public Collection<Producto> getProductos() {
		return productos;
	}

	public Collection<Promocion1> getPromociones() {
		return promociones;
	}

	public void setPromociones(Collection<Promocion1> promociones) {
		this.promociones = promociones;
	}

	public void setProductos(Collection<Producto> productos) {
		this.productos = productos;
	}

	public Usuario(Integer id, String nombre, String password, Collection<Producto> productos,
			Collection<Promocion1> promociones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.productos = productos;
		this.promociones = promociones;
	}
   
	
	
}
