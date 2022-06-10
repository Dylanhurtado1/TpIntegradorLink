package ar.edu.utn.link.tpintegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String nombre;

	private String password;

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

	public Usuario() {
		super();
	}

}
