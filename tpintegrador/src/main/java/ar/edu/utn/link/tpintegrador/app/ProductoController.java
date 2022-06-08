package ar.edu.utn.link.tpintegrador.app;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import ar.edu.utn.link.tpintegrador.model.Producto;

@RestController //aviso que esta clase es un controller
@RequestMapping("/productos")//mapeo con la url que va a matchear
public class ProductoController {
	
	@Autowired//asocia el atributo con el repo que tengo
	private RepoProductoMem repo;

	@GetMapping("")
	public Collection<Producto>  list(@RequestParam(value ="nombre", required = false) String nombre) {
			return repo.all();
	}
	
	@PostMapping("")//con esto agrego materias
	public String post(@RequestBody Producto producto){//despues hago la validez para que no incluya un producto que ya existe
			repo.save(producto);
			return "ok";
		}
	
}
