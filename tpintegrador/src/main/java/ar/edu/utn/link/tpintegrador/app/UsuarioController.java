package ar.edu.utn.link.tpintegrador.app;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

	
	
	
	
	//	@Autowired
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

	//@PutMapping("/usuarios")
	//public ResponseEntity<?> modificarUsuario(@RequestBody Usuario usuario) {

		//Usuario newUsuario = repousuario.save(usuario);
		//return ResponseEntity.ok(newUsuario);
	//}

}
