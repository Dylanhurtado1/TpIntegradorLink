package ar.edu.utn.link.tpintegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Promocion1 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	String nombre;
	
    Float descuento;

	public void aplicarDescuento(Producto producto) {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Promocion1(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Promocion1() {
		super();
	}

	public Float getDescuento() {
		return descuento;
	}

	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}
	
	


}
