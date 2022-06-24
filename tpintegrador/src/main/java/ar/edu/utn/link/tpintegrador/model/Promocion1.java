package ar.edu.utn.link.tpintegrador.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED) SOLO ESTO ESTABA ANTES
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo")
public  class Promocion1 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nombre;
    Float descuento;

    //esto funcionara?
	public  void aplicarDescuento(Producto producto) {
		
	}

	public Promocion1(String nombre, Float descuento) {
		super();
		this.nombre = nombre;
		this.descuento = descuento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Promocion1(Float descuento) {
		super();
		this.descuento = descuento;
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
