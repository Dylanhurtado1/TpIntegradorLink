package ar.edu.utn.link.tpintegrador.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class PromocionDTO {

	@NotBlank
	private String nombre;
	
	@Min(0)
	private Float descuento;

	public PromocionDTO(@NotBlank String nombre, @Min(0) Float descuento) {
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

	public Float getDescuento() {
		return descuento;
	}

	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}

	public PromocionDTO() {
		super();
	}
	
	
	
}
