package com.api.security.config;

import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
	
public static void addAuthentication(HttpServletResponse res, String username) {
		
		
		Instant issuedAt = Instant.now().truncatedTo(ChronoUnit.SECONDS);
	    Instant expiration = issuedAt.plus(60, ChronoUnit.MINUTES); //expiración del token
		
	    //creacion del token
		String token = Jwts.builder()
				.setSubject(username)
				//vamos a asignar un tiempo de expiracion de 1 minuto
				.setExpiration(Date.from(expiration))
				//hash con el que firmaremos la clave , algoritmo HS512 MAS POTENTE 
				//P@tit0 es una palabra clave Para la creación de los tokens
				.signWith(SignatureAlgorithm.HS512, "P@tit0")
				.compact();
		
		System.out.println("token: "+token);
		
		//agregamos al encabezado el token
		res.addHeader("Authorization", "Bearer "+token);
		
		
	}


	//Metodo para validar el token enviado por el cliente
	public static Authentication getAuthentication(HttpServletRequest req) {
	
		//obtenemos el token que viene en el emcabezado de la peticion
		String token = req.getHeader("Authorization");
	
		System.out.println("Token cliente : "+token);
		if(token != null){
			String user = Jwts.parser()
				.setSigningKey("P@tit0")
				.parseClaimsJws(token.replace("Bearer", "")) // este metodo valida el token
				.getBody()
				.getSubject(); // es el user
		
			System.out.println("user : " + user);
		
			//Recordemos que para las demas peticiones que no sean /login
			//no requerimos una autenticacion por username / password
			//por este motivo podemos devolver un UsernamePasswordAuthenticationToken sin password 
		
			return user!=null? new UsernamePasswordAuthenticationToken(user, null, emptyList())
				:null;
		}
		return null;
	
	}
	
	private static Collection<? extends GrantedAuthority> emptyList() {
		
		return null;
	}

}
