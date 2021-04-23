package com.api.rest.dto;

import java.util.List;

import com.api.model.entity.GolModel;
import com.api.model.entity.JugadorModel;

public class JugadorGolFullDTO {
	
	private JugadorModel jugador;
	private List<GolModel> gol;
	
	public JugadorModel getJugador() {
		return jugador;
	}
	public void setJugador(JugadorModel jugador) {
		this.jugador = jugador;
	}
	public List<GolModel> getGol() {
		return gol;
	}
	public void setGol(List<GolModel> gol) {
		this.gol = gol;
	}
	public JugadorGolFullDTO(JugadorModel jugador, List<GolModel> gol) {
		super();
		this.jugador = jugador;
		this.gol = gol;
	}
	
	

}
