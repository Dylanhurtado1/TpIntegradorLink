package ar.edu.utn.link.tpintegrador.app;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.link.tpintegrador.model.Cliente;



@RestController //aviso que esta clase es un controller
@RequestMapping("/clientes")//mapeo con la url que va a matchear
public class ClienteController {


	
	
	
	
	
	//@Autowired//asocia el atributo con el repo que tengo
	//private RepoClienteMem repo;
	
	
//	@GetMapping("")
//	public Collection<Cliente>  list(@RequestParam(value ="nombre", required = false) String nombre) {
//			return repo.all();
//	}
	
//	@PostMapping("")//con esto agrego materias
//	public String post(@RequestBody Cliente cliente){//despues hago la validez para que no incluya un producto que ya existe
//			repo.save(cliente);
//			return "ok";
//		}
	//creo que termine alta de clientes
}
