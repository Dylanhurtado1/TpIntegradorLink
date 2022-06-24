package ar.edu.utn.link.tpintegrador.app;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.link.tpintegrador.dtos.Mensaje;
import ar.edu.utn.link.tpintegrador.dtos.PromocionDTO;
import ar.edu.utn.link.tpintegrador.model.CuponProveedor;
import ar.edu.utn.link.tpintegrador.model.Promocion1;
import ar.edu.utn.link.tpintegrador.service.PromocionService;

@RestController
@RequestMapping("/promocion")//estoy cambiando a usuario
@CrossOrigin(origins = "*")
public class PromocionController {

	@Autowired
    PromocionService promocionService;
	
//Factura f = new FacturaReducida("1", "tableta", 100);
	
	
	@PreAuthorize("hasRole('VENDEDOR')") //PERMITE POST PRODUCTOS SOLO A LOS Vendedores, aca interviene el dto
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PromocionDTO promocionDto){
       if(StringUtils.isBlank(promocionDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(promocionService.existsByNombre(promocionDto.getNombre()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Promocion1 promocion = new CuponProveedor(promocionDto.getNombre(), promocionDto.getDescuento());//con un constructor que tenga el nombre de vendedor solamente ya funcionó
        promocionService.save(promocion);
        return new ResponseEntity(new Mensaje("promocion creada"), HttpStatus.OK);
    }

	@GetMapping("/lista") //devuelve lista de productos
    public ResponseEntity<List<Promocion1>> list(){
        List<Promocion1> list = promocionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }// NO HAY INTERACCION CON EL USUARIO	
	
}
