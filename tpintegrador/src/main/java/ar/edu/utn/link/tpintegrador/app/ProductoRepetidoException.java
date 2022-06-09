package ar.edu.utn.link.tpintegrador.app;

import ar.edu.utn.link.tpintegrador.model.Producto;

public class ProductoRepetidoException extends Exception{

private static final long serialVersionUID = 1L;
	
	private Producto producto;
	
	public ProductoRepetidoException(Producto producto) {
		this.producto = producto;
	}

	public ProductoRepetidoException() {
		super();
	}

	public ProductoRepetidoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ProductoRepetidoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductoRepetidoException(String message) {
		super(message);
	}

	public ProductoRepetidoException(Throwable cause) {
		super(cause);
	}

	public Producto getProducto() {
		return producto;
	}
	
}
