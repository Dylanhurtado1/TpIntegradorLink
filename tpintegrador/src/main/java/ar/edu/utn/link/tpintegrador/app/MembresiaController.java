package ar.edu.utn.link.tpintegrador.app;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ar.edu.utn.link.tpintegrador.dtos.Mensaje;
import ar.edu.utn.link.tpintegrador.dtos.PromocionDTO;
import ar.edu.utn.link.tpintegrador.model.Membresia;
import ar.edu.utn.link.tpintegrador.model.Promocion1;

public class MembresiaController extends PromocionController{



	@Override
	@PreAuthorize("hasRole('USER')") //PERMITE POST PRODUCTOS SOLO A LOS Vendedores, aca interviene el dto
    @PostMapping("/create/membresia")
    public ResponseEntity<?> create(@RequestBody PromocionDTO promocionDto){
        if(StringUtils.isBlank(promocionDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(promocionService.existsByNombre(promocionDto.getNombre()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Promocion1 promocion = new Membresia(promocionDto.getNombre(), promocionDto.getDescuento());//con un constructor que tenga el nombre de vendedor solamente ya funcionó
        promocionService.save(promocion);
        return new ResponseEntity(new Mensaje("promocion creada"), HttpStatus.OK);
    }










}
