package ar.edu.utn.link.tpintegrador.dtos;

import javax.validation.constraints.NotBlank;


public class UsuarioDTO {

	@NotBlank
	private String nombre;
	@NotBlank
	private String password;

	public UsuarioDTO() {
	}

	public UsuarioDTO(@NotBlank String nombre, @NotBlank String password) {
		this.nombre = nombre;
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
