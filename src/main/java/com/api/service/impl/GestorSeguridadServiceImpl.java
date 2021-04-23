package com.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.jpa.entity.SecurityRestJPA;
import com.api.jpa.repository.GestorSeguridadRepository;



@Service("securityService")
public class GestorSeguridadServiceImpl implements UserDetailsService {
	
	@Autowired
	@Qualifier("repositorioSecurity")
	private GestorSeguridadRepository repositorio ;

	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		
		// lo busca por usuario
		SecurityRestJPA user = repositorio.findByUsuario(usuario);
				
		//codifica la clave
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return new User(user.getUsuario(), encoder.encode(user.getClave()),
				user.isActivo(),user.isActivo(),user.isActivo(),user.isActivo(),
				buildGranted(user.getRol()));
	}

	private List<GrantedAuthority> buildGranted(byte rol){
		String [] roles= {"LECTOR", "USUARIO" , "ADMINISTRADOR"};
		List<GrantedAuthority> auths = new ArrayList<>();
		
		for (int i = 0; i < rol; i++) {
			auths.add(new SimpleGrantedAuthority(roles[i]));
		}
		
		return auths;
			
		}
}
