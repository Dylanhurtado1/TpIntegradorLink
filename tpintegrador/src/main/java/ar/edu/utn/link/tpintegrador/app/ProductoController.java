package ar.edu.utn.link.tpintegrador.app;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.link.tpintegrador.model.Producto;

@RestController //aviso que esta clase es un controller
@RequestMapping("/productos")//mapeo con la url que va a matchear
public class ProductoController {
	
	//@Autowired//asocia el atributo con el repo que tengo
	//private RepoProductoMem repo;

	@Autowired
	@Qualifier("jpa3")
	private RepoProducto repo;

	
	
	
//	@GetMapping("")//solo devuelve la lista de productos
//	public Collection<Producto>  list(@RequestParam(value ="nombre", required = false) String nombre) {
//			return repo.all();
//	}
	
	@GetMapping("")
	public Page<Producto> list(@RequestParam(value = "anio",required = false) Integer anio, Pageable page){
		if(anio == null) {
			return repo.findAll(page);
		}else {
			return repo.findByAnio(anio, page);
		}
		
	}
	
	@GetMapping("/{nombre}")//get de acuerdo al nombre de la materia
	public Producto get(@PathVariable("nombre") String nombreProducto) {
		return repo.findByNombre(nombreProducto);
	}
	
	@Transactional
	@PostMapping("")//post de materias
	public String post(@RequestBody @Valid Producto producto,			
			BindingResult bindingResult) throws ProductoRepetidoException {
		if(!bindingResult.hasErrors()) {
			repo.save(producto);
			return "ok";
		} else {
			bindingResult.getFieldErrors().stream().forEach(x -> {
				System.out.print(  x.getField());
				x.getDefaultMessage();
			});
			return "no ok, con errores";
		}
	}
	
	
	
	//@PostMapping("")//con esto agrego materias
	//public String post(@RequestBody Producto producto){//despues hago la validez para que no incluya un producto que ya existe
	//		repo.save(producto);
	//		return "ok";
	//	}
	
}
