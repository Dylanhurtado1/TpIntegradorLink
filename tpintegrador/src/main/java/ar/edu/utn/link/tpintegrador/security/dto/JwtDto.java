package ar.edu.utn.link.tpintegrador.security.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import ar.edu.utn.link.tpintegrador.security.entity.Usuario1;

public class JwtDto {

	  private String token;
	    private String bearer = "Bearer";
	    private String nombreUsuario;
	    private Collection<? extends GrantedAuthority> authorities;
       private Usuario1 usuario;//esto lo puse ahora
	    public JwtDto(String token, String nombreUsuario, Collection<? extends GrantedAuthority> authorities) {
	        this.token = token;
	        this.nombreUsuario = nombreUsuario;
	        this.authorities = authorities;
	    }

	    public Usuario1 getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario1 usuario) {
			this.usuario = usuario;
		}

		public String getToken() {
	        return token;
	    }

	    public void setToken(String token) {
	        this.token = token;
	    }

	    public String getBearer() {
	        return bearer;
	    }

	    public void setBearer(String bearer) {
	        this.bearer = bearer;
	    }

	    public String getNombreUsuario() {
	        return nombreUsuario;
	    }

	    public void setNombreUsuario(String nombreUsuario) {
	        this.nombreUsuario = nombreUsuario;
	    }

	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return authorities;
	    }

	    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
	        this.authorities = authorities;
	    }
}
