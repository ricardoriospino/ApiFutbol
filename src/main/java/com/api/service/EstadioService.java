package com.api.service;

import java.util.List;

import com.api.model.entity.EstadioModel;

public interface EstadioService {

	public boolean insertar (EstadioModel estadio);
	
	public boolean actualizar (EstadioModel estadio);
	
	public boolean borrar (int id);
	
	public List<EstadioModel> obtenerEstadios();
	
	public EstadioModel obtenerEstadioPorNombre (String nombre);
}
