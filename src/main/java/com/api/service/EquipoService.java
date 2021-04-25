package com.api.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.api.model.entity.EquipoEstadioModel;
import com.api.model.entity.EquipoModel;
import com.api.rest.dto.EquipoFullDTO;

public interface EquipoService {
	
	public boolean insertar (EquipoModel equipo);
	
	public boolean insertarEquipoEstadio (EquipoEstadioModel equipoEstadio);
	
	public boolean actualizar (EquipoModel equipo);
	
	public boolean borrar (int id);
	
	public List<EquipoModel> obtenerEquipos();
	
	public EquipoFullDTO obtenerListaTitulos ();
	
	public EquipoModel obtenerEquipoPorNombre(String nombre);
	
	public EquipoFullDTO obtenerEquipoFPorNombre (String nombre);
	
	// metodo con paginacion
	public List<EquipoModel> obtenerEquiposPaginacion (Pageable paginacion);

}
