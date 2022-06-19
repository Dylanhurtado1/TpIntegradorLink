package ar.edu.utn.link.tpintegrador.app;

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
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.link.tpintegrador.dtos.Mensaje;
import ar.edu.utn.link.tpintegrador.dtos.ProductoDTO;
import ar.edu.utn.link.tpintegrador.model.Producto;
import ar.edu.utn.link.tpintegrador.service.ProductoService;

@RestController // aviso que esta clase es un controller
@RequestMapping("/producto") // mapeo con la url que va a matchear
@CrossOrigin(origins = "*")
public class ProductoController {

	    @Autowired
	    ProductoService productoService;

	    @GetMapping("/lista") //devuelve lista de productos
	    public ResponseEntity<List<Producto>> list(){
	        List<Producto> list = productoService.list();
	        return new ResponseEntity(list, HttpStatus.OK);
	    }// NO HAY INTERACCION CON EL USUARIO

	    @GetMapping("/detail/{id}") //devuelve detalle de cada producto
	    public ResponseEntity<Producto> getById(@PathVariable("id") int id){
	        if(!productoService.existsById(id))
	            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
	        Producto producto = productoService.getOne(id).get();
	        return new ResponseEntity(producto, HttpStatus.OK); //responde con un producto
	    }

	    @GetMapping("/detailname/{nombre}") // devuelve producto segun nombre
	    public ResponseEntity<Producto> getByNombre(@PathVariable("nombre") String nombre){
	        if(!productoService.existsByNombre(nombre))
	            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
	        Producto producto = productoService.getByNombre(nombre).get();
	        return new ResponseEntity(producto, HttpStatus.OK);
	    }

	    @PreAuthorize("hasRole('VENDEDOR')") //PERMITE POST PRODUCTOS SOLO A LOS ADMINS
	    @PostMapping("/create")
	    public ResponseEntity<?> create(@RequestBody ProductoDTO productoDto){
	        if(StringUtils.isBlank(productoDto.getNombre()))
	            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
	        if(productoDto.getPrecio()==null || productoDto.getPrecio()<0 )
	            return new ResponseEntity(new Mensaje("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
	        if(productoService.existsByNombre(productoDto.getNombre()))
	            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
	        Producto producto = new Producto(productoDto.getNombre(), productoDto.getPrecio());
	        productoService.save(producto);
	        return new ResponseEntity(new Mensaje("producto creado"), HttpStatus.OK);
	    }

	    @PreAuthorize("hasRole('VENDEDOR')") // PERMITE MODIFICAR SOLO A LOS ADMINS
	    @PutMapping("/update/{id}")
	    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ProductoDTO productoDto){
	        if(!productoService.existsById(id))
	            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
	        if(productoService.existsByNombre(productoDto.getNombre()) && productoService.getByNombre(productoDto.getNombre()).get().getId() != id)
	            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
	        if(StringUtils.isBlank(productoDto.getNombre()))
	            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
	        if(productoDto.getPrecio()==null || productoDto.getPrecio()<0 )
	            return new ResponseEntity(new Mensaje("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);

	        Producto producto = productoService.getOne(id).get();
	        producto.setNombre(productoDto.getNombre());
	        producto.setPrecio(productoDto.getPrecio());
	        productoService.save(producto);
	        return new ResponseEntity(new Mensaje("producto actualizado"), HttpStatus.OK);
	    }

	    @PreAuthorize("hasRole('VENDEDOR')") // PERMITE ELIMINAR A LOS ADMIN
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> delete(@PathVariable("id")int id){
	        if(!productoService.existsById(id))
	            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
	        productoService.delete(id);
	        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
	    }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Autowired
//	@Qualifier("jpa3")
//	private RepoProducto repo;

//	@GetMapping("")
//	public Page<Producto> list(@RequestParam(value = "anio",required = false) Integer anio, Pageable page){
//		if(anio == null) {
//			return repo.findAll(page);
//		}else {
//			return repo.findByAnio(anio, page);
//		}

//	}

//	@GetMapping("/{nombre}")//get de acuerdo al nombre de la materia
//	public Producto get(@PathVariable("nombre") String nombreProducto) {
//		return repo.findByNombre(nombreProducto);
//	}

//	@Transactional
//	@PostMapping("")//post de materias
//	public String post(@RequestBody @Valid Producto producto,			
//			BindingResult bindingResult) throws ProductoRepetidoException {
//		if(!bindingResult.hasErrors()) {
//			repo.save(producto);
//			return "ok";
//		} else {
//			bindingResult.getFieldErrors().stream().forEach(x -> {
//				System.out.print(  x.getField());
//				x.getDefaultMessage();
//			});
//			return "no ok, con errores";
//		}
//	}

}
