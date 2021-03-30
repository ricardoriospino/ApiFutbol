package com.api.service;


import java.util.List;

import org.springframework.data.domain.Pageable;

import com.api.model.entity.JugadorModel;

public interface JugadorService {

	public boolean insertar (JugadorModel jugador);
	
	public boolean actualizar (JugadorModel jugador);
	
	public boolean borrar (int id);
	
	public List<JugadorModel> obtenerJugadores();
	
	public JugadorModel obtenerJugadorPorDorsalyNacionalidad(int dorsal , String nacionalidad);
	
	// metodo con paginacion
	public List<JugadorModel> obtenerJugadoresPaginacion(Pageable paginacion);
}
