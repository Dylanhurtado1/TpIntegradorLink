package ar.edu.utn.link.tpintegrador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Promocion1 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// @Column(name = "promocion_codigo")
	private Integer id;

	String nombre;

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

}
