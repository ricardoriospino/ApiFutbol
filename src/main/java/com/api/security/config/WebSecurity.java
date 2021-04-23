package com.api.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.api.service.impl.GestorSeguridadServiceImpl;




@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	@Qualifier("securityService")
	private GestorSeguridadServiceImpl security;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(security);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests() //desactiva la autenticacion para /login
		.antMatchers("/login","/apiNotav1/notas").permitAll()//("/login","/apiNotav1/notas","") puedes agregar varios permitidos
		.anyRequest().authenticated()
		.and()
		//las peticiones /login pasaran previamente por este filtro
		.addFilterBefore(new LoginFilter("/login", authenticationManager()), 
				UsernamePasswordAuthenticationFilter.class)
		//las demas peticiones pasaran por este filtro para validar el token
		.addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class);
		
	}

}
