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

@RepositoryRestController
public class ClienteControllerComplement {

	@Autowired
	RepoCliente repoCliente; //iria repo Cliente, repoProducto
	
	@Autowired
	RepoProducto repoProducto;
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST,value="/clientes/{clienteId}/comprar")
	public @ResponseBody String comprar(@PathVariable("clienteId") Integer clienteId,
			@RequestBody Integer productoId) {
		
		Optional<Cliente> opcionalCliente = repoCliente.findById(clienteId);//encuentra a ese alumno de la url
		if(opcionalCliente.isEmpty()) {
			return "cliente no encontrado";
		}
		Cliente cliente = opcionalCliente.get();//aca lo agarra
		//Solo son excepciones
		Optional<Producto> opcionalProducto = repoProducto.findById(productoId);
		if(opcionalProducto.isEmpty()) {
			return "producto no encontrado";
		}
		Producto producto = opcionalProducto.get();//agarro producto
		
		//-----------------------------
		//try 
		//{
			//alumno.inscribir(curso);
		cliente.comprar(producto);
		//} catch(CompraException ex) {
		//	return "el cliente ya compro este producto";
		//}
		//-----------------------------------
		
		return "ok";
	}

	
	
}
