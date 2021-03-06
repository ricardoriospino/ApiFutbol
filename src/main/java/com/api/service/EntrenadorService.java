package com.api.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.api.model.entity.EntrenadorModel;
import com.api.model.entity.EquipoEntrenadorModel;


public interface EntrenadorService {
	
	public boolean insertar (EntrenadorModel entrenador);
	
	public boolean insertarEntrenadorEquipo (EquipoEntrenadorModel entrenadorEquipo);
	
	public boolean actualizar (EntrenadorModel entrenador);
	
	public boolean borrar (String nombre , int id, int partidosJugados );
	
	public List<EntrenadorModel> obtenerEntrenadores();
	
	public  Object obtenerEntrenadorPorNombreyNacionalidad (String nombre , String nacionalidad);

	public List<EntrenadorModel> obtenerEntrenadorPorNacionalidad (String nacionalidad);
	
	public EntrenadorModel obtenerEntrenadorPorCodigo(String codigo);
	
	public Object obtenerEntrenadorPorIdEntrenador (int idEntrenador);
	
	public Object obtenerEntrenadorFporCodigo(String codigo);
	
	// metodo con paginacion
	public List<EntrenadorModel> obtenerEntrenadoresPaginacion(Pageable paginacion);
}
