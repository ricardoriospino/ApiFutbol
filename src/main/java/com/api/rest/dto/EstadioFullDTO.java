package com.api.rest.dto;

import java.util.List;

import com.api.model.entity.EquipoEstadioModel;
import com.api.model.entity.EstadioModel;

public class EstadioFullDTO {
	
	private EstadioModel estadio;
	
	private List<EquipoEstadioModel> equipoEstadio;
	
	public EstadioFullDTO() {
		
	}

	public EstadioModel getEstadio() {
		return estadio;
	}

	public void setEstadio(EstadioModel estadio) {
		this.estadio = estadio;
	}

	public List<EquipoEstadioModel> getEquipoEstadio() {
		return equipoEstadio;
	}

	public void setEquipoEstadio(List<EquipoEstadioModel> equipoEstadio) {
		this.equipoEstadio = equipoEstadio;
	}

	public EstadioFullDTO(EstadioModel estadio, List<EquipoEstadioModel> equipoEstadio) {
		super();
		this.estadio = estadio;
		this.equipoEstadio = equipoEstadio;
	}
	
	

}
