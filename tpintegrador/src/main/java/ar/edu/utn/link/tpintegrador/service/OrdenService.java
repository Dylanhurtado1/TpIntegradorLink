package ar.edu.utn.link.tpintegrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.utn.link.tpintegrador.app.RepoOrdenDeCompra;
import ar.edu.utn.link.tpintegrador.model.OrdenDeCompra;

@Service
@Transactional
public class OrdenService {

	@Autowired
	RepoOrdenDeCompra ordenRepository;

	public List<OrdenDeCompra> list() {
		return ordenRepository.findAll();
	}

	public Optional<OrdenDeCompra> getOne(int id) {
		return ordenRepository.findById(id);
	}

	//public Optional<OrdenDeCompra> getByNombre(String nombre) {
	//	return ordenRepository.findByNombre(nombre);
	//}

	public void save(OrdenDeCompra orden) {
		ordenRepository.save(orden);
	}

	public void delete(int id) {
		ordenRepository.deleteById(id);
	}

	public boolean existsById(int id) {
		return ordenRepository.existsById(id);
	}

	//public boolean existsByNombre(String nombre){
	// return ordenRepository.existsByNombre(nombre);
	// } 
}
