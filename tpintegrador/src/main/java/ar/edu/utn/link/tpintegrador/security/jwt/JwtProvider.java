package ar.edu.utn.link.tpintegrador.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import ar.edu.utn.link.tpintegrador.security.entity.UsuarioPrincipal;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtProvider {

	   private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

	    @Value("${jwt.secret}")
	    private String secret; //ESTO ESTA EN LAS PROPERTIES

	    @Value("${jwt.expiration}")
	    private int expiration;

	    //LO IMPORTANTE, GENERA EL TOKENNN
	    public String generateToken(Authentication authentication){
	        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();//casteo para tener su autenticacion
	        return Jwts.builder().setSubject(usuarioPrincipal.getUsername()) // aca hace la magia de generar el token
	                .setIssuedAt(new Date())
	                .setExpiration(new Date(new Date().getTime() + expiration * 1000))//la expiracion
	                .signWith(SignatureAlgorithm.HS512, secret)
	                .compact();
	    }

	    public String getNombreUsuarioFromToken(String token){
	        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
	        //get subject es nombreDeUsuario
	    }

	    public boolean validateToken(String token){
	        try {
	            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
	            return true;//valida el token
	        }catch (MalformedJwtException e){
	            logger.error("token mal formado");
	        }catch (UnsupportedJwtException e){
	            logger.error("token no soportado");
	        }catch (ExpiredJwtException e){
	            logger.error("token expirado");
	        }catch (IllegalArgumentException e){
	            logger.error("token vacío");
	        }catch (SignatureException e){
	            logger.error("fail en la firma");
	        }
	        return false;
	    }
	
	
}
