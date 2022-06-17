package ar.edu.utn.link.tpintegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CuponProveedor  extends Promocion1{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	
	private String nombre;
	
//	private double descuento;

	@Override
	public void aplicarDescuento(Producto producto) {

		producto.aplicarDescuento(descuento);
	}

	public CuponProveedor(String nombre, Float descuento) {
		super();
		this.nombre = nombre;
		this.descuento = descuento;
	}

	
	public Float getDescuento() {
		return descuento;
	}
    
	public void setDescuento(Float descuento) {
		this.descuento = descuento;
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

	public CuponProveedor() {
		super();
	}
	
	
	

}
