package com.api.service;


import java.util.List;

import org.springframework.data.domain.Pageable;

import com.api.model.entity.EquipoJugadorModel;
import com.api.model.entity.FaltaModel;
import com.api.model.entity.GolModel;
import com.api.model.entity.JugadorModel;


public interface JugadorService {

	public boolean insertar (JugadorModel jugador);
	
	public boolean insertarJugadorEquipo (EquipoJugadorModel jugadorEquipo);
	
	public boolean insertarFaltaJugadorPartido (FaltaModel falta);
	
	public boolean insertarGolJugadorPartido (GolModel gol);
	
	public boolean actualizar (JugadorModel jugador);
	
	public boolean borrar (int id);
	
	public List<JugadorModel> obtenerJugadores();
	
	
	public Object obtenerJugadorPorDorsalyNacionalidad(int dorsal , String nacionalidad);
	
	public Object obtenerJugadorPorCodigo (String codigo);
	
	public Object obtenerJugadorFporCodigo (String codigo);
	
	public Object obtenerJugadorPorNombre (String nombre);
	
	public Object obtenerJugadorFporNombre (String nombre);
	
	public Object obtenerJugadorFporNombreGol (String nombre);
	
	public Object obtenerJugadorFullGolyFaltaPorNombre (String nombre);
	
	// metodo con paginacion
	public List<JugadorModel> obtenerJugadoresPaginacion(Pageable paginacion);
}
