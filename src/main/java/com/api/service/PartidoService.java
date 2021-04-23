package com.api.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.api.model.entity.PartidoModel;
import com.api.rest.dto.PartidoFullDTO;

public interface PartidoService {
	
	public boolean insertarPartido (PartidoModel partido);
	
	public boolean actualizar (PartidoModel partido);
	
	public boolean borrar(int id  );
	
	public List<PartidoModel> obtenerPartidos();
	
	public List<PartidoModel> obtenerPartidosPorArbitro(String arbitro);
	
	public List<PartidoModel> obtenerPartidosPorFecha (Date fechaPartido);
	
	public List<PartidoModel> obtenerPartidosPaginados (Pageable paginacion);
	
	public PartidoModel obtenerPartidoPorCodigo (String codigo);
	
	public PartidoFullDTO obtenerPartidoFporCodigo (String codigo);
	
	

}
