package com.api.rest.dto;

import java.util.List;


import com.api.model.entity.FaltaModel;
import com.api.model.entity.GolModel;
import com.api.model.entity.JugadorModel;

public class JugadorGolFaltaFullDTO {
	
	private JugadorModel jugador;
	private List<GolModel> gol;
	private List<FaltaModel >falta;
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
	public List<FaltaModel> getFalta() {
		return falta;
	}
	public void setFalta(List<FaltaModel> falta) {
		this.falta = falta;
	}
	
	
	public JugadorGolFaltaFullDTO(JugadorModel jugador, List<GolModel> gol, List<FaltaModel> falta) {
		super();
		this.jugador = jugador;
		this.gol = gol;
		this.falta = falta;
	}
	
	

}
