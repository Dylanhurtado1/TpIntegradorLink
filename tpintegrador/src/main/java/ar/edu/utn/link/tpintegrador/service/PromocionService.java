package ar.edu.utn.link.tpintegrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.utn.link.tpintegrador.app.RepoPromocion;
import ar.edu.utn.link.tpintegrador.model.Promocion1;

@Service
@Transactional
public class PromocionService {

	@Autowired
	RepoPromocion promocionRepository;

	public List<Promocion1> list() {
		return promocionRepository.findAll();
	}

	public Optional<Promocion1> getOne(int id) {
		return promocionRepository.findById(id);
	}

	public Optional<Promocion1> getByNombre(String nombre) {
		return promocionRepository.findByNombre(nombre);
	}

	public void save(Promocion1 p) {
		promocionRepository.save(p);
	}

	public void delete(int id) {
		promocionRepository.deleteById(id);
	}

	public boolean existsById(int id) {
		return promocionRepository.existsById(id);
	}

	public boolean existsByNombre(String nombre) {
		return promocionRepository.existsByNombre(nombre);
	}

}
