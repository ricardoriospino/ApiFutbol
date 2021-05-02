package com.api.respuesta.model;

import java.io.Serializable;

import com.api.rest.dto.JugadorFullDTO;

public class RespuestaJugadorFull implements Serializable {
	
	private JugadorFullDTO jugadorFull;
	
	public RespuestaJugadorFull() {
		
	}

	public RespuestaJugadorFull(JugadorFullDTO jugadorFull) {
		super();
		this.jugadorFull = jugadorFull;
	}

	public JugadorFullDTO getJugadorFull() {
		return jugadorFull;
	}

	public void setJugadorFull(JugadorFullDTO jugadorFull) {
		this.jugadorFull = jugadorFull;
	}
	
	

}
