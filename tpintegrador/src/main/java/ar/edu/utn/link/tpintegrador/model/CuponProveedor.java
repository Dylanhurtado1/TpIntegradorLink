package ar.edu.utn.link.tpintegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class CuponProveedor  extends Promocion1{
	//implements Promocion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	double descuento;
	

	@Override
	public void aplicarDescuento(Producto producto) {

		producto.aplicarDescuento(descuento);
	}

	public CuponProveedor(String nombre, double descuento) {
		super();
		this.nombre = nombre;
		this.descuento = descuento;
	}

}
