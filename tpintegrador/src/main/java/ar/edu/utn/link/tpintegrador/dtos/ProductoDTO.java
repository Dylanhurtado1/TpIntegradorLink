package ar.edu.utn.link.tpintegrador.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import ar.edu.utn.link.tpintegrador.security.entity.Usuario1;

public class ProductoDTO {

	@NotBlank
	private String nombre;
	@Min(0)
	private Float precio;

	private Usuario1 usuario;

	public ProductoDTO(@NotBlank String nombre, @Min(0) Float precio, Usuario1 usuario) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.usuario = usuario;
	}

	public Usuario1 getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario1 usuario) {
		this.usuario = usuario;
	}

	public ProductoDTO(@NotBlank String nombre, @Min(0) Float precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	public ProductoDTO() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}



}
