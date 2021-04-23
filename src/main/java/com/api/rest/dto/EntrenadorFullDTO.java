package com.api.rest.dto;

import java.util.List;


import com.api.model.entity.EntrenadorModel;
import com.api.model.entity.EquipoEntrenadorModel;

public class EntrenadorFullDTO {
	
	private EntrenadorModel entrenador;
	private List<EquipoEntrenadorModel> equipoEntrenador; 

	public EntrenadorFullDTO() {
		
	}

	public EntrenadorModel getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(EntrenadorModel entrenador) {
		this.entrenador = entrenador;
	}


	public List<EquipoEntrenadorModel> getEquipoEntrenador() {
		return equipoEntrenador;
	}

	public void setEquipoEntrenador(List<EquipoEntrenadorModel> equipoEntrenador) {
		this.equipoEntrenador = equipoEntrenador;
	}

	public EntrenadorFullDTO(EntrenadorModel entrenador,
			List<EquipoEntrenadorModel> equipoEntrenador) {
		super();
		this.entrenador = entrenador;
		this.equipoEntrenador = equipoEntrenador;
	}

	

	

}
