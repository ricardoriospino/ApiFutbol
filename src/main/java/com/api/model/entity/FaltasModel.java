package com.api.model.entity;

import java.io.Serializable;

import com.api.jpa.entity.FaltasJPA;
import com.api.jpa.entity.JugadorJPA;

public class FaltasModel implements Serializable {
	
	
	private int idFaltas;
	private int faltasAmarilla;
	private int faltasRojas;
	private JugadorJPA jugador;
	
	public int getIdFaltas() {
		return idFaltas;
	}
	public void setIdFaltas(int idFaltas) {
		this.idFaltas = idFaltas;
	}
	public int getFaltasAmarilla() {
		return faltasAmarilla;
	}
	public void setFaltasAmarilla(int faltasAmarilla) {
		this.faltasAmarilla = faltasAmarilla;
	}
	public int getFaltasRojas() {
		return faltasRojas;
	}
	public void setFaltasRojas(int faltasRojas) {
		this.faltasRojas = faltasRojas;
	}
	public JugadorJPA getJugador() {
		return jugador;
	}
	public void setJugador(JugadorJPA jugador) {
		this.jugador = jugador;
	}
	
	public FaltasModel() {
		
	}
	
	
	public FaltasModel(int idFaltas, int faltasAmarilla, int faltasRojas, JugadorJPA jugador) {
		super();
		this.idFaltas = idFaltas;
		this.faltasAmarilla = faltasAmarilla;
		this.faltasRojas = faltasRojas;
		this.jugador = jugador;
	}
	
	public FaltasModel(FaltasJPA faltas) {
		this.idFaltas = faltas.getIdFaltas();
		this.faltasAmarilla = faltas.getFaltasAmarilla();
		this.faltasRojas = faltas.getFaltasRojas();
		this.jugador = faltas.getJugador();
	}
	@Override
	public String toString() {
		return "FaltasModel [idFaltas=" + idFaltas + ", faltasAmarilla=" + faltasAmarilla + ", faltasRojas="
				+ faltasRojas + ", jugador=" + jugador + "]";
	}
	
	

}
