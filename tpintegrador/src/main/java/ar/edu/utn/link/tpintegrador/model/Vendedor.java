package ar.edu.utn.link.tpintegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
@Entity
public class Vendedor {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nombre;
	private String apellido;

	
}
