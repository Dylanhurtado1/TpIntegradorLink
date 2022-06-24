package ar.edu.utn.link.tpintegrador.app;

import java.text.DecimalFormat;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ar.edu.utn.link.tpintegrador.dtos.Mensaje;
import ar.edu.utn.link.tpintegrador.dtos.ProductoDTO;
import ar.edu.utn.link.tpintegrador.dtos.UsuarioDTO;
import ar.edu.utn.link.tpintegrador.model.OrdenDeCompra;
import ar.edu.utn.link.tpintegrador.model.Producto;
import ar.edu.utn.link.tpintegrador.model.ResponseCotizacionDolar;
import ar.edu.utn.link.tpintegrador.security.entity.Usuario1;
import ar.edu.utn.link.tpintegrador.service.ProductoService;
import ar.edu.utn.link.tpintegrador.service.UsuarioService;

@RestController // aviso que esta clase es un controller
@RequestMapping("/producto") // mapeo con la url que va a matchear
@CrossOrigin(origins = "*")
public class ProductoController {

	@Autowired
	ProductoService productoService;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	RepoOrdenDeCompra repoOrden;

	DecimalFormat formato1 = new DecimalFormat("#.00");

	@GetMapping("/lista")
	public ResponseEntity<List<Producto>> list() { // devuelve una lista de productos, deberia devolverlos paginado
		List<Producto> list = productoService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@GetMapping("/detail/{id}") // devuelve detalle del producto segun el id
	public ResponseEntity<Producto> getById(@PathVariable("id") int id) {
		if (!productoService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe el producto"), HttpStatus.NOT_FOUND);
		Producto producto = productoService.getOne(id).get(); // solo retorna un producto con ese id
		return new ResponseEntity(producto, HttpStatus.OK);
	}

	@GetMapping("/detailname/{nombre}") // devuelve producto segun nombre
	public ResponseEntity<Producto> getByNombre(@PathVariable("nombre") String nombre) {
		if (!productoService.existsByNombre(nombre))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		Producto producto = productoService.getByNombre(nombre).get();
		return new ResponseEntity(producto, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('VENDEDOR')") // si es vendedor puede hacer post de productos
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody ProductoDTO productoDto) {// por postman puedo mandar un producto
		if (StringUtils.isBlank(productoDto.getNombre()))
			return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if (productoDto.getPrecio() == null || productoDto.getPrecio() < 0)
			return new ResponseEntity(new Mensaje("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
		if (productoService.existsByNombre(productoDto.getNombre()))
			return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
		Producto producto = new Producto(productoDto.getNombre(), productoDto.getPrecio(), productoDto.getUsuario());
		productoService.save(producto);
		return new ResponseEntity(new Mensaje("producto creado"), HttpStatus.OK);
	}

	@PreAuthorize("hasRole('VENDEDOR')") // PERMITE MODIFICAR SOLO A LOS ADMINS
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProductoDTO productoDto) {
		if (!productoService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		if (productoService.existsByNombre(productoDto.getNombre())
				&& productoService.getByNombre(productoDto.getNombre()).get().getId() != id)
			return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
		if (StringUtils.isBlank(productoDto.getNombre()))
			return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if (productoDto.getPrecio() == null || productoDto.getPrecio() < 0)
			return new ResponseEntity(new Mensaje("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);

		Producto producto = productoService.getOne(id).get();
		producto.setNombre(productoDto.getNombre());
		producto.setPrecio(productoDto.getPrecio());
		productoService.save(producto);
		return new ResponseEntity(new Mensaje("producto actualizado"), HttpStatus.OK);
	}

	@PreAuthorize("hasRole('VENDEDOR')") // PERMITE ELIMINAR A LOS ADMIN
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if (!productoService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		productoService.delete(id);
		return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
	}

	// tengo que matchear con esto la parte del front
	@PreAuthorize("hasRole('USER')") // PERMITE comprar solo a los usuarios
	@PostMapping("/comprar2/{idProducto}/{idUsuario}") // comprar segun id del producto
	public ResponseEntity<?> comprar2(@PathVariable("idProducto") int idProducto,
			@PathVariable("idUsuario") String username) {

		Producto producto = productoService.getOne(idProducto).get();
		Usuario1 usuario = usuarioService.getByNombreUsuario(username).get();
		OrdenDeCompra orden = new OrdenDeCompra();

		Double a = precioEnDolares();
		double b = producto.getPrecio() / a;
		formato1.format(b);
		orden.setPrecioFinalEnDolares(b);
		orden.setPrecioFinal(producto.getPrecio());
		orden.setProducto(producto);
		orden.setComprador(usuario);
		orden.setNombreProducto(producto.getNombre());
		orden.setNombreUsuario(username);
		orden = repoOrden.save(orden);// con esto los relaciona

		return new ResponseEntity(orden, HttpStatus.OK); // Devuelve una orden, con esto el data de angular machea
	}

	@PreAuthorize("hasRole('USER')")
	@RequestMapping(method = RequestMethod.GET, value = "/dolar")
	public Double precioEnDolares() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ResponseCotizacionDolar> response = restTemplate.getForEntity(
				"https://api-dolar-argentina.herokuapp.com/api/dolaroficial", ResponseCotizacionDolar.class);
		ResponseCotizacionDolar body = response.getBody();
		return body.getVenta();
	}

	// A ver este metodo comprar
	@PreAuthorize("hasRole('USER')") // PERMITE comprar solo a los usuarios
	@PostMapping("/comprar/{idProducto}/{nombreUsuario}") // comprar segun id del producto
	public ResponseEntity<?> comprar(@PathVariable("idProducto") int idProducto,
			@PathVariable("nombreUsuario") String nombreUsuario) {

		Producto producto = productoService.getOne(idProducto).get();
		Usuario1 usuario = usuarioService.getByNombre(nombreUsuario).get();
		OrdenDeCompra orden = new OrdenDeCompra();

		orden.setPrecioFinal(producto.getPrecio());
		orden.setComprador(usuario);
		orden = repoOrden.save(orden);// con esto los relaciona

		return new ResponseEntity(new Mensaje("producto comprado"), HttpStatus.OK);
	}

}
