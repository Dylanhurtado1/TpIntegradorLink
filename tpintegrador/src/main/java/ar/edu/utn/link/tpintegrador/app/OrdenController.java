package ar.edu.utn.link.tpintegrador.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.link.tpintegrador.dtos.Mensaje;
import ar.edu.utn.link.tpintegrador.model.OrdenDeCompra;
import ar.edu.utn.link.tpintegrador.service.OrdenService;

@RestController // aviso que esta clase es un controller
@RequestMapping("/orden") // mapeo con la url que va a matchear
@CrossOrigin(origins = "*")
public class OrdenController {

	@Autowired
	OrdenService ordenService;
	
	  @GetMapping("/detail/{id}") //devuelve el obejto ordenDeCompra con esa id
	    public ResponseEntity<OrdenDeCompra> getById(@PathVariable("id") int id){
	        if(!ordenService.existsById(id))
	            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
	        OrdenDeCompra orden = ordenService.getOne(id).get(); // solo retorna un producto con ese id, lo mismo debe pasar con orden De Compra
	        return new ResponseEntity(orden, HttpStatus.OK); //responde con un producto
	    }
	
	
	
	
}
