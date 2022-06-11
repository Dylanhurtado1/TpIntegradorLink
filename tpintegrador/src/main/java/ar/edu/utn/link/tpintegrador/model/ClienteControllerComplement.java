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

import ar.edu.utn.link.tpintegrador.app.RepoCliente;
import ar.edu.utn.link.tpintegrador.app.RepoProducto;
import ar.edu.utn.link.tpintegrador.app.RepoUsuario;

@RepositoryRestController
public class ClienteControllerComplement {

	@Autowired
	RepoCliente repoCliente; // iria repo Cliente, repoProducto

	@Autowired
	RepoProducto repoProducto;
	
	@Autowired
	RepoUsuario repoUsuario;
	

	@Transactional//comprar productos
	@RequestMapping(method = RequestMethod.POST, value = "/clientes/{clienteId}/comprar")
	public @ResponseBody String comprar(@PathVariable("clienteId") Integer clienteId, @RequestBody Integer productoId) {

		Optional<Cliente> opcionalCliente = repoCliente.findById(clienteId);// encuentra a ese alumno de la url
		if (opcionalCliente.isEmpty()) {
			return "cliente no encontrado";
		}
		Cliente cliente = opcionalCliente.get();// aca lo agarra
		// Solo son excepciones
		Optional<Producto> opcionalProducto = repoProducto.findById(productoId);
		if (opcionalProducto.isEmpty()) {
			return "producto no encontrado";
		}
		Producto producto = opcionalProducto.get();// agarro producto

		cliente.comprar(producto);

		Vendedor vendedor = producto.getVendedor();
	    OrdenDeCompra orden = new OrdenDeCompra();
		orden.setCliente(cliente);
		orden.setVendedor(vendedor);
		
		
		return "ok";
	}
	
	@Transactional//registrarse
	@RequestMapping(method = RequestMethod.POST, value = "/clientes/{clienteId}/registrar")
	public @ResponseBody String registrar(@PathVariable("clienteId") Integer clienteId, @RequestBody Integer usuarioId) {

		Optional<Cliente> opcionalCliente = repoCliente.findById(clienteId);// encuentra a ese alumno de la url
		if (opcionalCliente.isEmpty()) {
			return "cliente no encontrado";
		}
		Cliente cliente = opcionalCliente.get();// aca lo agarra
		// Solo son excepciones
		Optional<Usuario> opcionalUsuario = repoUsuario.findById(usuarioId);
		if (opcionalUsuario.isEmpty()) {
			return "usuario no encontrado";
		}
		Usuario usuario = opcionalUsuario.get();// agarro producto

		cliente.setUsuario(usuario);//seria como registrarse

		return "ok";
	}	
	
	

}
