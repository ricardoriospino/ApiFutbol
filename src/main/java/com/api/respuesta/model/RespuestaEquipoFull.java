package com.api.respuesta.model;

import java.io.Serializable;

import com.api.rest.dto.EquipoFullDTO;

public class RespuestaEquipoFull implements Serializable {

	private EquipoFullDTO equipoFull;
	
	public RespuestaEquipoFull() {
		
	}

	public RespuestaEquipoFull(EquipoFullDTO equipoFull) {
		super();
		this.equipoFull = equipoFull;
	}

	public EquipoFullDTO getEquipoFull() {
		return equipoFull;
	}

	public void setEquipoFull(EquipoFullDTO equipoFull) {
		this.equipoFull = equipoFull;
	}
	
	
}
