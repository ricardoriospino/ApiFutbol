package com.api.respuesta.model;

import java.io.Serializable;
import java.util.List;

import com.api.model.entity.EntrenadorModel;

public class RespuestaListaEntrenador implements Serializable {
	
	private List<EntrenadorModel> listaEntrenadores ;
	
	
	public RespuestaListaEntrenador() {
		
	}
	
	public RespuestaListaEntrenador(List<EntrenadorModel> listaEntrenadores) {
		super();
		this.listaEntrenadores = listaEntrenadores;
	}



	public List<EntrenadorModel> getListaEntrenadores() {
		return listaEntrenadores;
	}

	public void setListaEntrenadores(List<EntrenadorModel> listaEntrenadores) {
		this.listaEntrenadores = listaEntrenadores;
	}
	
	
	

}
