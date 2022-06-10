package ar.edu.utn.link.tpintegrador.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {
	private RepoVendedor repo;

}
