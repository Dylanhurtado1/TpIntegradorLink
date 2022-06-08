package ar.edu.utn.link.tpintegrador.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import ar.edu.utn.link.tpintegrador.model.Cliente;
@Repository
public class RepoClienteMem {

	private Collection<Cliente> clientes;
	
	public RepoClienteMem() {
		super();
		List<Cliente> of =  List.of(new Cliente("Dylan","Hurtado"),new Cliente("Sergio","Fernandez"),new Cliente("Facundo","Orellana"),
		new Cliente("Jorge","Gimenez"),new Cliente("Agustin","Hidalgo"));
        clientes = new ArrayList<Cliente>(of);	//Con esto puedo agregar materias
	}
	
	
	public Collection<Cliente> all(){
		return clientes;
	}
	
	public void save(Cliente cliente) {
		this.clientes.add(cliente);
	}
	
}
