package com.api.respuesta.model;

import java.io.Serializable;
import java.util.List;

import com.api.model.entity.PartidoModel;

public class RespuestaListaPartido implements Serializable {
	
	private List<PartidoModel> listaPartidos;
	
	public RespuestaListaPartido() {
		
	}

	public RespuestaListaPartido(List<PartidoModel> listaPartidos) {
		super();
		this.listaPartidos = listaPartidos;
	}

	public List<PartidoModel> getListaPartidos() {
		return listaPartidos;
	}

	public void setListaPartidos(List<PartidoModel> listaPartidos) {
		this.listaPartidos = listaPartidos;
	}
	
	

}
