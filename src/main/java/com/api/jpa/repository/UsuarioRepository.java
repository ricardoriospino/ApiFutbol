package com.api.jpa.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.jpa.entity.UsuarioJPA;

@Repository("repositorioUsuario")
public interface UsuarioRepository extends JpaRepository<UsuarioJPA, Serializable> {
	
	public UsuarioJPA findByIdUsuario (int vid);
	
	public UsuarioJPA findByNombre (String vnombre);
	
	public UsuarioJPA findByCodigoUsuario (String vcodigoUsuario);
	
	public UsuarioJPA findByUsuario (String vusuario);
	
	public List<UsuarioJPA> findByIsEnable (boolean vIsEnable);
	
	public UsuarioJPA findByUsuarioAndClave (String vusuario, String vclave);
	
	public UsuarioJPA findTopByOrderByIdUsuarioDesc();

}
