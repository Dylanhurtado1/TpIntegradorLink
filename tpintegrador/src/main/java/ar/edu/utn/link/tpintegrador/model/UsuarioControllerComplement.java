package ar.edu.utn.link.tpintegrador.model;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.utn.link.tpintegrador.app.RepoCarrito;
import ar.edu.utn.link.tpintegrador.app.RepoOrdenDeCompra;
import ar.edu.utn.link.tpintegrador.app.RepoProducto;
import ar.edu.utn.link.tpintegrador.app.RepoPromocion;
import ar.edu.utn.link.tpintegrador.app.RepoUsuario;

@RepositoryRestController
public class UsuarioControllerComplement {

	@Autowired
	RepoUsuario repoUsuario;

	@Autowired
	RepoProducto repoProducto;

	@Autowired
	RepoOrdenDeCompra repoOrden;

	@Autowired
	RepoPromocion repoPromocion;
	
	@Autowired
	RepoCarrito repoCarrito;

/*    @Transactional // EL USUARIO COMPRA UN PRODUCTO
	@RequestMapping(method = RequestMethod.POST, value = "/usuarios/{usuarioId}/comprar")
	public @ResponseBody String comprar(@PathVariable("usuarioId") Integer usuarioId, @RequestBody Integer productoId) {

		Optional<Usuario> opcionalUsuario = repoUsuario.findById(usuarioId);
		if (opcionalUsuario.isEmpty()) {
			return "usuario no encontrado";
		}
		Usuario usuario = opcionalUsuario.get();// aca lo * agarra // Solo son excepciones
		Optional<Producto> opcionalProducto = repoProducto.findById(productoId);
		if (opcionalProducto.isEmpty()) {
			return "producto no encontrado";
		}
		Producto producto = opcionalProducto.get();

		usuario.comprar(producto);// definir metodo comprar para usuario
       // usuario.aplicarDescuento(producto); //PROBLEMAS DE QUE ME CAMBIA EL PRECIO DEL PRODUCTO
		// Vendedor vendedor = producto.getVendedor();
		OrdenDeCompra orden = new OrdenDeCompra();
		orden.setUsuario(usuario); // orden.setVendedor(vendedor);
		orden.setProducto(producto);
		orden.setPrecioFinal(producto.getPrecio());
		repoOrden.save(orden);// con esto los relaciona

		return "ok";
	} */

    @Transactional // EL USUARIO COMPRA UN PRODUCTO
	@RequestMapping(method = RequestMethod.POST, value = "/usuarios/{usuarioId}/obtenerPromocion")
	public @ResponseBody String obtenerPromocion(@PathVariable("usuarioId") Integer usuarioId, @RequestBody Integer promocionId) {

		Optional<Usuario> opcionalUsuario = repoUsuario.findById(usuarioId);
		if (opcionalUsuario.isEmpty()) {
			return "usuario no encontrado";
		}
		Usuario usuario = opcionalUsuario.get();
		Optional<Promocion1> opcionalPromocion = repoPromocion.findById(promocionId);
		if (opcionalPromocion.isEmpty()) {
			return "promocion no encontrada";
		}
		Promocion1 promocion = opcionalPromocion.get();
		usuario.setPromocion(promocion);
		return "ok";
	} 





@Transactional // EL USUARIO MUCHOS PRODUCTOS NO ME FUNCAAA
	@RequestMapping(method = RequestMethod.POST, value = "/usuarios/{usuarioId}/comprarCarrito")
	public @ResponseBody String comprarCarrito(@PathVariable("usuarioId") Integer usuarioId,
			@RequestBody Integer carritoId) {

		Optional<Usuario> opcionalUsuario = repoUsuario.findById(usuarioId);// encuentra a ese alumno de la url
		if (opcionalUsuario.isEmpty()) {
			return "usuario no encontrado";
		}
		Usuario usuario = opcionalUsuario.get();// aca lo agarra
		// Solo son excepciones
		Optional<Carrito> opcionalCarrito = repoCarrito.findById(carritoId);
		if (opcionalCarrito.isEmpty()) {
			return "carrito no encontrado";
		}
		Carrito carrito = opcionalCarrito.get();// agarro producto

		usuario.comprarCarrito(carrito);// definir metodo comprar para usuario

		OrdenDeCompra orden = new OrdenDeCompra();

		double precioFin = carrito.obtenerPrecioFinalDeOrden(carrito.getProductos());
		orden.setUsuario(usuario);
		orden.getProductos().addAll(carrito.getProductos());
		//FALTO EL PRECIO FINALLL
		orden.setPrecioFinal(precioFin);
		//orden.setProductos(carrito.getProductos());
		repoOrden.save(orden);// con esto los relaciona

		return "ok";
	}
	

}
