package com.api.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.api.model.entity.EstadioModel;
import com.api.rest.dto.EstadioFullDTO;

public interface EstadioService {

	public boolean insertar (EstadioModel estadio);
	
	public boolean actualizar (EstadioModel estadio);
	
	public boolean borrar (int id );
	
	public List<EstadioModel> obtenerEstadios();
	
	public Object obtenerEstadioPorNombre (String nombre);
	
	public EstadioModel obtenerEstadioPorCodigo(String codigo);
	
	public Object obtenerEstadioPorFcodigo (String codigo);
	
	// metodo con paginacion
	public List<EstadioModel> obtenerEstadiosPaginacion(Pageable paginacion);
}
