package com.api.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.api.model.entity.EquipoEstadioModel;
import com.api.model.entity.EquipoModel;
import com.api.rest.dto.EquipoFullDTO;

public interface EquipoService {
	
	public boolean insertar (EquipoModel equipo);
	
	public boolean insertarEquipoEstadio (EquipoEstadioModel equipoEstadio);
	
	public int actualizar (EquipoModel equipo);
	
	public boolean borrar (int id);
	
	public List<EquipoModel> obtenerEquipos();
	
	public List<EquipoFullDTO> obtenerListaTitulos ();
	
	public Object obtenerEquipoPorNombre(String nombre);
	
	public Object obtenerEquipoPorCodigo (String codigo);
	
	public Object obtenerEquipoPorId (int idEquipo);
	
	public Object obtenerEquipoFPorNombre (String nombre);
	
	// metodo con paginacion
	public List<EquipoModel> obtenerEquiposPaginacion (Pageable paginacion);

}
