package com.api.model.entity;

import java.io.Serializable;

import com.api.jpa.entity.JugadorJPA;

public class JugadorModel implements Serializable {
	
	private int idJugador;
	private String nombreJugador;
	private int edad;
	private int aniosDeCarrera;
	private String nacionalidad;
	private int dorsal;
	private String posicion;
	public int getIdJugador() {
		return idJugador;
	}
	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}
	public String getNombreJugador() {
		return nombreJugador;
	}
	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getAniosDeCarrera() {
		return aniosDeCarrera;
	}
	public void setAniosDeCarrera(int aniosDeCarrera) {
		this.aniosDeCarrera = aniosDeCarrera;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public int getDorsal() {
		return dorsal;
	}
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	public JugadorModel() {
		
	}
	public JugadorModel(int idJugador, String nombreJugador, int edad, int aniosDeCarrera, String nacionalidad,
			int dorsal, String posicion) {
		super();
		this.idJugador = idJugador;
		this.nombreJugador = nombreJugador;
		this.edad = edad;
		this.aniosDeCarrera = aniosDeCarrera;
		this.nacionalidad = nacionalidad;
		this.dorsal = dorsal;
		this.posicion = posicion;
	}
	
	public JugadorModel(JugadorJPA jugador) {
		this.idJugador = jugador.getIdJugador();
		this.nombreJugador = jugador.getNombreJugador();
		this.edad = jugador.getEdad();
		this.aniosDeCarrera = jugador.getAniosDeCarrera();
		this.nacionalidad = jugador.getNacionalidad();
		this.dorsal = jugador.getDorsal();
		this.posicion = jugador.getPosicion();
	}
	@Override
	public String toString() {
		return "JugadorModel [idJugador=" + idJugador + ", nombreJugador=" + nombreJugador + ", edad=" + edad
				+ ", aniosDeCarrera=" + aniosDeCarrera + ", nacionalidad=" + nacionalidad + ", dorsal=" + dorsal
				+ ", posicion=" + posicion + "]";
	}
	
	

}
