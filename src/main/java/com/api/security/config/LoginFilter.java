package com.api.security.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

//valida las credenciales del usuario enviado
public class LoginFilter extends AbstractAuthenticationProcessingFilter {
	
	protected LoginFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager) {
		super(defaultFilterProcessesUrl, authenticationManager);
		
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException, IOException, ServletException {
		
		InputStream body = req.getInputStream();
		AutenticacionRest user = new ObjectMapper().readValue(body, AutenticacionRest.class);
		
		System.out.println(user);
		
		return getAuthenticationManager().authenticate(
			new UsernamePasswordAuthenticationToken(
					user.getUsuario(), user.getClave(),Collections.emptyList()
					)
				);
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		// si la autenticacion fue exitosa , agregamos el token a la respuesta
		
		JwtUtil.addAuthentication (res, authResult.getName());
	}

}
