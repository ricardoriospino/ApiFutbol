package com.api.rest.dto;

import java.util.List;

import com.api.model.entity.EquipoJugadorModel;
import com.api.model.entity.FaltaModel;
import com.api.model.entity.GolModel;
import com.api.model.entity.JugadorModel;

public class JugadorFullDTO {
	
	private JugadorModel jugador;
	private List<EquipoJugadorModel> equipoJugador;
	private List<FaltaModel> falta;
	
	
	public JugadorFullDTO() {
		
	}

	public JugadorModel getJugador() {
		return jugador;
	}

	public void setJugador(JugadorModel jugador) {
		this.jugador = jugador;
	}

	public List<EquipoJugadorModel> getEquipoJugador() {
		return equipoJugador;
	}

	public void setEquipoJugador(List<EquipoJugadorModel> equipoJugador) {
		this.equipoJugador = equipoJugador;
	}
	public List<FaltaModel> getFalta() {
		return falta;
	}

	public void setFalta(List<FaltaModel> falta) {
		this.falta = falta;
	}

	public JugadorFullDTO(JugadorModel jugador, List<EquipoJugadorModel> equipoJugador) {
		super();
		this.jugador = jugador;
		this.equipoJugador = equipoJugador;
	}

	public JugadorFullDTO(JugadorModel jugador, List<EquipoJugadorModel> equipoJugador, List<FaltaModel> falta) {
		super();
		this.jugador = jugador;
		this.equipoJugador = equipoJugador;
		this.falta = falta;
	}

	public JugadorFullDTO( List<FaltaModel> falta ,JugadorModel jugador) {
		super();
		this.falta = falta;
		this.jugador = jugador;
		
	}

	
	
	
	
	

	
	
	


}
