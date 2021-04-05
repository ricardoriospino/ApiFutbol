package com.api.model.entity;

import java.io.Serializable;

import com.api.jpa.entity.GolesJPA;
import com.api.jpa.entity.JugadorJPA;
import com.api.jpa.entity.PartidoJPA;

public class GolesModel implements Serializable {
	
	private int idGoles;
	private int minutoGol;
	private String descripcionGol;
	private JugadorJPA jugador;
	private PartidoJPA partido;
	
	
	
	public int getIdGoles() {
		return idGoles;
	}
	public void setIdGoles(int idGoles) {
		this.idGoles = idGoles;
	}
	public int getMinutoGol() {
		return minutoGol;
	}
	public void setMinutoGol(int minutoGol) {
		this.minutoGol = minutoGol;
	}
	public String getDescripcionGol() {
		return descripcionGol;
	}
	public void setDescripcionGol(String descripcionGol) {
		this.descripcionGol = descripcionGol;
	}
	public JugadorJPA getJugador() {
		return jugador;
	}
	public void setJugador(JugadorJPA jugador) {
		this.jugador = jugador;
	}
	public PartidoJPA getPartido() {
		return partido;
	}
	public void setPartido(PartidoJPA partido) {
		this.partido = partido;
	}
	
	public GolesModel() {
		
	}
	
	
	public GolesModel(int idGoles, int minutoGol, String descripcionGol, JugadorJPA jugador, PartidoJPA partido) {
		super();
		this.idGoles = idGoles;
		this.minutoGol = minutoGol;
		this.descripcionGol = descripcionGol;
		this.jugador = jugador;
		this.partido = partido;
	}
	
	
	public GolesModel (GolesJPA goles) {
		this.idGoles = goles.getIdGoles();
		this.minutoGol = goles.getMinutoGol();
		this.descripcionGol = goles.getDescripcionGol();
		this.jugador = goles.getJugador();
		this.partido = goles.getPartido();
	}
	
	@Override
	public String toString() {
		return "GolesModel [idGoles=" + idGoles + ", minutoGol=" + minutoGol + ", descripcionGol=" + descripcionGol
				+ ", jugador=" + jugador + ", partido=" + partido + "]";
	}
	
	
	
	

}
