package ar.edu.utn.link.tpintegrador.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DiscriminatorValue(value = "CuponProveedor")
public class CuponProveedor extends Promocion1 {

	@Override
	public void aplicarDescuento(Producto producto) {

		//producto.aplicarDescuento(descuento);
		float a = producto.getPrecio() - descuento; // si es un cupon se le resta el descuento correspondiente
		producto.setPrecio(a);
	}

	public CuponProveedor(float descuento) {
		super(descuento);
		// TODO Auto-generated constructor stub
	}
	
	

	public CuponProveedor(Float descuento) {
		super(descuento);
		// TODO Auto-generated constructor stub
	}

	public CuponProveedor(String nombre, Float descuento) {
		super(nombre, descuento);
		// TODO Auto-generated constructor stub
	}

	public CuponProveedor() {
		super();
	}

}
