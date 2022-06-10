package ar.edu.utn.link.tpintegrador.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // aviso que esta clase es un controller
@RequestMapping("/productos") // mapeo con la url que va a matchear
public class ProductoController {

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
