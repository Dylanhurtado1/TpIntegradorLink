package ar.edu.utn.link.tpintegrador.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ProductoDTO {

	@NotBlank
	private String nombre;
	@Min(0)
	private Float precio;
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

	/* String getNombre();

	// Double getPrecio();*/
	
	
	
	
	
	
	
	}
	

	// @Value("#{target.vendedor.getNombre()}")
	// String getNombreVendedor();


