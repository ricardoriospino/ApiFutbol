package com.api.service;


import java.util.List;

import com.api.model.entity.TituloModel;

public interface TituloService {
	
	public boolean insertar (TituloModel titulo);
	
	public boolean actualizar (TituloModel titulo);
	
	public boolean borrar ( int id);
	
	public List<TituloModel> obtenerTitulos();
	
	
}
