package com.api.service;


import java.util.List;

import org.springframework.data.domain.Pageable;

import com.api.model.entity.EquipoJugadorModel;
import com.api.model.entity.FaltaModel;
import com.api.model.entity.GolModel;
import com.api.model.entity.JugadorModel;
import com.api.rest.dto.JugadorFullDTO;
import com.api.rest.dto.JugadorGolFaltaFullDTO;
import com.api.rest.dto.JugadorGolFullDTO;

public interface JugadorService {

	public boolean insertar (JugadorModel jugador);
	
	public boolean insertarJugadorEquipo (EquipoJugadorModel jugadorEquipo);
	
	public boolean insertarFaltaJugadorPartido (FaltaModel falta);
	
	public boolean insertarGolJugadorPartido (GolModel gol);
	
	public boolean actualizar (JugadorModel jugador);
	
	public boolean borrar (int id);
	
	public List<JugadorModel> obtenerJugadores();
	
	
	public JugadorModel obtenerJugadorPorDorsalyNacionalidad(int dorsal , String nacionalidad);
	
	public JugadorModel obtenerJugadorPorCodigo (String codigo);
	
	public JugadorFullDTO obtenerJugadorFporCodigo (String codigo);
	
	public JugadorModel obtenerJugadorPorNombre (String nombre);
	
	public JugadorFullDTO obtenerJugadorFporNombre (String nombre);
	
	public JugadorGolFullDTO obtenerJugadorFporNombreGol (String nombre);
	
	public JugadorGolFaltaFullDTO obtenerJugadorFullGolyFaltaPorNombre (String nombre);
	
	// metodo con paginacion
	public List<JugadorModel> obtenerJugadoresPaginacion(Pageable paginacion);
}
