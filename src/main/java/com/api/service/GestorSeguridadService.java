package com.api.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public interface GestorSeguridadService {

	public List<GrantedAuthority> buildGrantedAuthorities (byte rol);
}
