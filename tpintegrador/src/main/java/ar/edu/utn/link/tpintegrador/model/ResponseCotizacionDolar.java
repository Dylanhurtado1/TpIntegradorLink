package ar.edu.utn.link.tpintegrador.model;

import java.util.Date;

public class ResponseCotizacionDolar {

	private String fecha;
	private  Double compra;
	private Double venta;
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Double getCompra() {
		return compra;
	}
	public void setCompra(Double compra) {
		this.compra = compra;
	}
	public Double getVenta() {
		return venta;
	}
	public void setVenta(Double venta) {
		this.venta = venta;
	}
	
}
