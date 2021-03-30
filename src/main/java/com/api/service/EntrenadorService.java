package com.api.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.api.model.entity.EntrenadorModel;

public interface EntrenadorService {
	
	public boolean insertar (EntrenadorModel entrenador);
	
	public boolean actualizar (EntrenadorModel entrenador);
	
	public boolean borrar (String nombre , int id);
	
	public List<EntrenadorModel> obtenerEntrenadores();
	
	public EntrenadorModel obtenerEntrenadorPorNombreyNacionalidad (String nombre , String nacionalidad);

	// metodo con paginacion
	public List<EntrenadorModel> obtenerEntrenadoresPaginacion(Pageable paginacion);
}
