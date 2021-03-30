package com.api.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.api.model.entity.EquipoModel;

public interface EquipoService {
	
	public boolean insertar (EquipoModel equipo);
	
	public boolean actualizar (EquipoModel equipo);
	
	public boolean borrar (int id);
	
	public List<EquipoModel> obtenerEquipos();
	
	public EquipoModel obtenerEquipoPorNombre(String nombre);
	
	// metodo con paginacion
	public List<EquipoModel> obtenerEquiposPaginacion (Pageable paginacion);

}
