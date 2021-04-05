package com.api.model.entity;

import java.io.Serializable;

import com.api.jpa.entity.FaltasJPA;
import com.api.jpa.entity.JugadorJPA;
import com.api.jpa.entity.PartidoJPA;

public class FaltasModel implements Serializable {
	
	
	private int idFaltas;
	private String tipoFalta;
	private int minutoFalta;
	private JugadorJPA jugador;
	private PartidoJPA partido;
	
	
	public int getIdFaltas() {
		return idFaltas;
	}


	public void setIdFaltas(int idFaltas) {
		this.idFaltas = idFaltas;
	}


	public String getTipoFalta() {
		return tipoFalta;
	}


	public void setTipoFalta(String tipoFalta) {
		this.tipoFalta = tipoFalta;
	}


	public int getMinutoFalta() {
		return minutoFalta;
	}


	public void setMinutoFalta(int minutoFalta) {
		this.minutoFalta = minutoFalta;
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


	public FaltasModel() {
		
	}
	
	
	
	public FaltasModel(int idFaltas, String tipoFalta, int minutoFalta, JugadorJPA jugador, PartidoJPA partido) {
		super();
		this.idFaltas = idFaltas;
		this.tipoFalta = tipoFalta;
		this.minutoFalta = minutoFalta;
		this.jugador = jugador;
		this.partido = partido;
	}


	public FaltasModel(FaltasJPA faltas) {
		this.idFaltas = faltas.getIdFaltas();
		this.tipoFalta = faltas.getTipoFalta();
		this.minutoFalta = faltas.getMinutoFalta();
		this.jugador = faltas.getJugador();
		this.partido = faltas.getPartido();
	}


	@Override
	public String toString() {
		return "FaltasModel [idFaltas=" + idFaltas + ", tipoFalta=" + tipoFalta + ", minutoFalta=" + minutoFalta
				+ ", jugador=" + jugador + ", partido=" + partido + "]";
	}
	
	

}
