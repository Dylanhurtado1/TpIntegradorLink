package ar.edu.utn.link.tpintegrador.security.controllers;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.link.tpintegrador.dtos.Mensaje;
import ar.edu.utn.link.tpintegrador.security.dto.JwtDto;
import ar.edu.utn.link.tpintegrador.security.dto.LoginUsuario;
import ar.edu.utn.link.tpintegrador.security.dto.NuevoUsuario;
import ar.edu.utn.link.tpintegrador.security.entity.Rol;
import ar.edu.utn.link.tpintegrador.security.entity.Usuario1;
import ar.edu.utn.link.tpintegrador.security.enums.RolNombre;
import ar.edu.utn.link.tpintegrador.security.jwt.JwtProvider;
import ar.edu.utn.link.tpintegrador.security.service.RolService;
import ar.edu.utn.link.tpintegrador.security.service.Usuario1Service;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

	@Autowired
	PasswordEncoder passwordEncoder;//esto lo tuve que averiguar

	@Autowired
	AuthenticationManager authenticationManager;//tuve que averiguar para que sirve

	@Autowired
	Usuario1Service usuarioService;

	@Autowired
	RolService rolService;

	@Autowired
	JwtProvider jwtProvider;

	@PostMapping("/nuevo") // dar de alta usuarios
	public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return new ResponseEntity(new Mensaje("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
		if (usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
			return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
		if (usuarioService.existsByEmail(nuevoUsuario.getEmail()))
			return new ResponseEntity(new Mensaje("ese email ya existe"), HttpStatus.BAD_REQUEST);
		Usuario1 usuario = new Usuario1(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(),
				nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()), nuevoUsuario.getProfile());
		Set<Rol> roles = new HashSet<>();
		roles.add(rolService.findByProfile(nuevoUsuario.getProfile()).get());
		usuario.setRoles(roles);
		usuarioService.save(usuario);
		return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
	}

	@PostMapping("/login") // matchea con un usuario que ya existe, y devuelve el token
	public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
	Optional<Usuario1> usuario = usuarioService.getByNombreUsuario(loginUsuario.getNombreUsuario()) ;
		jwtDto.setUsuario(usuario.get());
		return new ResponseEntity(jwtDto, HttpStatus.OK);
	}

}
