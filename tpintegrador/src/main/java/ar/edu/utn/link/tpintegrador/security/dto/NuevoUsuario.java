package ar.edu.utn.link.tpintegrador.security.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NuevoUsuario { //todos estos atributos lo tendria el vendedor tambien

	  @NotBlank
	    private String nombre;
	    @NotBlank
	    private String nombreUsuario;
	    @Email
	    private String email;
	    @NotBlank
	    private String password;
	    private Set<String> roles = new HashSet<>();

	    private int profile;
	    
	    
	    public int getProfile() {
			return profile;
		}

		public void setProfile(int profile) {
			this.profile = profile;
		}

		public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getNombreUsuario() {
	        return nombreUsuario;
	    }

	    public void setNombreUsuario(String nombreUsuario) {
	        this.nombreUsuario = nombreUsuario;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public Set<String> getRoles() {
	        return roles;
	    }

	    public void setRoles(Set<String> roles) {
	        this.roles = roles;
	    }
	
	
}
