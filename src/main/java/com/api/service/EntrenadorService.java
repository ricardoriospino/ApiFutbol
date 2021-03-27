package com.api.service;

import java.util.List;

import com.api.model.entity.EntrenadorModel;

public interface EntrenadorService {
	
	public boolean insertar (EntrenadorModel entrenador);
	
	public boolean actualizar (EntrenadorModel entrenador);
	
	public boolean borrar (String nombre , int id);
	
	public List<EntrenadorModel> obtenerEntrenadores();
	
	public EntrenadorModel obtenerEntrenadorPorNombreyNacionalidad (String nombre , String nacionalidad);

}
