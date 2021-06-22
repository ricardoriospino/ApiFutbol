package com.api.service;

import java.util.List;

import com.api.model.entity.UsuarioModel;

public interface UsuarioService {
	
	public boolean insertar (UsuarioModel usuario);
	
	public boolean actualizar (UsuarioModel usuario);

	public boolean borrar (int id);
	
	public List<UsuarioModel> obtenerUsuarios ();
	
	public Object obtenerUsuarioPorNombre (String nombre);
	
	public Object obtenerUsuarioPorCodigoUsuario (String codigoUsuario);
	
	public Object obtenerUsuarioPorNombreUsuario (String nombreUsuario);
	
	public List<UsuarioModel> obtenerUsuarioPorEnable (boolean Enable);
	
	public boolean obtenerUsuarioPorNombreUsuarioClave  (UsuarioModel usuario);
	
	
	
}
