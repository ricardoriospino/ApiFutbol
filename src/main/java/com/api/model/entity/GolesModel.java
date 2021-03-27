package com.api.model.entity;

import java.io.Serializable;

import com.api.jpa.entity.GolesJPA;
import com.api.jpa.entity.JugadorJPA;

public class GolesModel implements Serializable {
	
	private int idGoles;
	private int totalGoles;
	private JugadorJPA jugador;
	
	public int getIdGoles() {
		return idGoles;
	}
	public void setIdGoles(int idGoles) {
		this.idGoles = idGoles;
	}
	public int getTotalGoles() {
		return totalGoles;
	}
	public void setTotalGoles(int totalGoles) {
		this.totalGoles = totalGoles;
	}
	public JugadorJPA getJugador() {
		return jugador;
	}
	public void setJugador(JugadorJPA jugador) {
		this.jugador = jugador;
	}
	
	public GolesModel() {
		
	}
	public GolesModel(int idGoles, int totalGoles, JugadorJPA jugador) {
		super();
		this.idGoles = idGoles;
		this.totalGoles = totalGoles;
		this.jugador = jugador;
	}
	
	public GolesModel (GolesJPA goles) {
		this.idGoles = goles.getIdGoles();
		this.totalGoles = goles.getTotalGoles();
		this.jugador = goles.getJugador();
	}
	@Override
	public String toString() {
		return "GolesModel [idGoles=" + idGoles + ", totalGoles=" + totalGoles + ", jugador=" + jugador + "]";
	}
	
	
	

}
