package ar.edu.utn.link.tpintegrador.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.link.tpintegrador.dtos.Mensaje;
import ar.edu.utn.link.tpintegrador.model.OrdenDeCompra;
import ar.edu.utn.link.tpintegrador.model.Producto;
import ar.edu.utn.link.tpintegrador.security.entity.Usuario1;
import ar.edu.utn.link.tpintegrador.service.ProductoService;
import ar.edu.utn.link.tpintegrador.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	ProductoService productoService;

	@Autowired
	RepoOrdenDeCompra repoOrden;

	@PreAuthorize("hasRole('USER')") // PERMITE comprar solo a los usuarios
	@PostMapping("/{idUsuario}/comprar/{idProducto}") // comprar segun id del producto
	public ResponseEntity<?> getById(@PathVariable("idUsuario") int idUsuario,
			@PathVariable("idProducto") int idProducto) { // hasta aca todo ok
		if (!productoService.existsById(idProducto))
			return new ResponseEntity(new Mensaje("no existe el producto"), HttpStatus.NOT_FOUND);
		if (!usuarioService.existsById(idUsuario))
			return new ResponseEntity(new Mensaje("no existe el usuario"), HttpStatus.NOT_FOUND);
		Producto producto = productoService.getOne(idProducto).get(); // con esto me devuelve el producto con ese id
		Usuario1 usuario = usuarioService.getOne(idUsuario).get(); // devuelve el usuario con ese id

		usuario.comprar(producto); // se agrega a la lista de productos del usuario
		OrdenDeCompra orden = new OrdenDeCompra();
		orden.setUsuario(usuario); // orden.setVendedor(vendedor);
		orden.setProducto(producto); // ver como tener estooooo
		orden.setPrecioFinal(producto.getPrecio());
		repoOrden.save(orden);// con esto los relaciona

		return new ResponseEntity(new Mensaje("producto comprado"), HttpStatus.OK);
	}

	@PreAuthorize("hasRole('USER')") // PERMITE comprar solo a los usuarios, bueno no funca por ahora. problema de inizializar
	@PostMapping("/{idUsuario}/agregar/{idProducto}") // comprar segun id del producto
	public ResponseEntity<?> agregar(@PathVariable("idUsuario") int idUsuario,
			@PathVariable("idProducto") int idProducto) { // hasta aca todo ok
		if (!productoService.existsById(idProducto))
			return new ResponseEntity(new Mensaje("no existe el producto"), HttpStatus.NOT_FOUND);
		if (!usuarioService.existsById(idUsuario))
			return new ResponseEntity(new Mensaje("no existe el usuario"), HttpStatus.NOT_FOUND);
		Producto producto = productoService.getOne(idProducto).get(); // con esto me devuelve el producto con ese id
		Usuario1 usuario = usuarioService.getOne(idUsuario).get(); // devuelve el usuario con ese id

		usuario.agregarACarrito(producto); // se agrega a la lista de productos del usuario
		return new ResponseEntity(new Mensaje("producto agregado a carrito"), HttpStatus.OK);
	}
	
	
	  @GetMapping("/lista") //devuelve lista de usuarios, solo si sos user
	    public ResponseEntity<List<Usuario1>> list(){
	        List<Usuario1> list = usuarioService.list();
	        return new ResponseEntity(list, HttpStatus.OK);
	    }

	
	
	
	/*
	 * @PreAuthorize("hasRole('USER')") // PERMITE POST PRODUCTOS SOLO A LOS ADMINS
	 * 
	 * @PostMapping("/comprar/{id}") //comprar segun id del producto public
	 * ResponseEntity<?> comprar(@RequestBody ProductoDTO productoDto) { if
	 * (StringUtils.isBlank(productoDto.getNombre())) return new ResponseEntity(new
	 * Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST); if
	 * (productoDto.getPrecio() == null || productoDto.getPrecio() < 0) return new
	 * ResponseEntity(new Mensaje("el precio debe ser mayor que 0"),
	 * HttpStatus.BAD_REQUEST); if
	 * (productoService.existsByNombre(productoDto.getNombre())) return new
	 * ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
	 * Producto producto = new Producto(productoDto.getNombre(),
	 * productoDto.getPrecio()); productoService.save(producto); return new
	 * ResponseEntity(new Mensaje("producto creado"), HttpStatus.OK); }
	 */

	// @Autowired
//	RepoUsuario repousuario;

//	@GetMapping("/usuarios")
//	public ResponseEntity<?> buscarUsuarios() {
//		Iterable<Usuario> lista = repousuario.findAll();
//		return ResponseEntity.ok(lista);
//	}

//	@PostMapping("/usuarios")
//	public ResponseEntity<?> agregarUsuario(@RequestBody Usuario usuario) {

//		Usuario newUsuario = repousuario.save(usuario);
//		return ResponseEntity.ok(newUsuario);
//	}

	// @PutMapping("/usuarios")
	// public ResponseEntity<?> modificarUsuario(@RequestBody Usuario usuario) {

	// Usuario newUsuario = repousuario.save(usuario);
	// return ResponseEntity.ok(newUsuario);
	// }

}
