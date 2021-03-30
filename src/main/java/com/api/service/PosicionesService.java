package com.api.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.api.model.entity.PosicionesModel;

public interface PosicionesService {
	
	public boolean insertar (PosicionesModel posiciones);
	
	public boolean actualizar (PosicionesModel posiciones);
	
	public boolean borrar ( int id);
	
	public List<PosicionesModel> obtenerPosiciones();
	
	// metodo con paginacion
	public List<PosicionesModel> obtenerPosicionesPaginacion(Pageable paginacion);

}
