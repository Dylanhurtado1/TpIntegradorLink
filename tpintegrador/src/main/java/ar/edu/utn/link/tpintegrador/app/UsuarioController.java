package ar.edu.utn.link.tpintegrador.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.link.tpintegrador.model.Usuario;

@RestController
public class UsuarioController {
	@Autowired
	RepoUsuario repousuario;

	@GetMapping("/usuarios")
	public ResponseEntity<?> buscarUsuarios() {
		Iterable<Usuario> lista = repousuario.findAll();
		return ResponseEntity.ok(lista);
	}

	@PostMapping("/usuarios")
	public ResponseEntity<?> agregarUsuario(@RequestBody Usuario usuario) {

		Usuario newUsuario = repousuario.save(usuario);
		return ResponseEntity.ok(newUsuario);
	}

	@PutMapping("/usuarios")
	public ResponseEntity<?> modificarUsuario(@RequestBody Usuario usuario) {

		Usuario newUsuario = repousuario.save(usuario);
		return ResponseEntity.ok(newUsuario);
	}

}
