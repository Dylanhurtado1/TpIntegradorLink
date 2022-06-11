package ar.edu.utn.link.tpintegrador.model;



public class CompraException extends RuntimeException{
	
	private Cliente cliente;
	private Producto producto;
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public Producto getProducto() {
		return producto;
	}
	
	public CompraException(String mensaje,Cliente cliente, Producto producto) {		
		super(mensaje);
		this.cliente = cliente;
		this.producto = producto;
	}

	public CompraException() {
		// TODO Auto-generated constructor stub
	}

	public CompraException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CompraException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public CompraException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CompraException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	
	
	

}
