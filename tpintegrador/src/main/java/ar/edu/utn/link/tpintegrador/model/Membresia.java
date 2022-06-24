package ar.edu.utn.link.tpintegrador.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Membresia")
public class Membresia extends Promocion1 {

	//POR AHORA MEMBRESIA Y CUPON LOS DESCUENTOS SON ASI
	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	// private Integer id;
	 String tipoMembresia;

	@Override
	public void aplicarDescuento(Producto producto) {

	//	producto.aplicarDescuento(descuento);
	float a  =	producto.getPrecio() - 100; // si es una membresia se le resta 100
	producto.setPrecio(a);
	}

	public Membresia(Float descuento,String tipoMembresia) {
		super(descuento);
		this.tipoMembresia = tipoMembresia;
	}

	public Membresia() {
		super();
	}

	public Membresia(Float descuento) {
		super(descuento);
		// TODO Auto-generated constructor stub
	}

	public Membresia(String nombre, Float descuento) {
		super(nombre, descuento);
		// TODO Auto-generated constructor stub
	}

}
