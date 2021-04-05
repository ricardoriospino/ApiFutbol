package com.api.model.entity;

import java.io.Serializable;
import java.util.Date;

import com.api.jpa.entity.JugadorJPA;

public class JugadorModel implements Serializable {
	
	private int idJugador;
	private String codigoJugador;
	private String nombreJugador;
	private Date fechaNacimiento;
	private int aniosDeDebut;
	private String nacionalidad;
	private int dorsal;
	private String posicion;
	private int numeroGoles;
	private int numeroFaltas;
	
	
	
	public int getIdJugador() {
		return idJugador;
	}
	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}
	public String getCodigoJugador() {
		return codigoJugador;
	}
	public void setCodigoJugador(String codigoJugador) {
		this.codigoJugador = codigoJugador;
	}
	public String getNombreJugador() {
		return nombreJugador;
	}
	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getAniosDeDebut() {
		return aniosDeDebut;
	}
	public void setAniosDeDebut(int aniosDeDebut) {
		this.aniosDeDebut = aniosDeDebut;
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
	public int getNumeroGoles() {
		return numeroGoles;
	}
	public void setNumeroGoles(int numeroGoles) {
		this.numeroGoles = numeroGoles;
	}
	public int getNumeroFaltas() {
		return numeroFaltas;
	}
	public void setNumeroFaltas(int numeroFaltas) {
		this.numeroFaltas = numeroFaltas;
	}
	
	public JugadorModel() {
		
	}
	
	
	public JugadorModel(int idJugador, String codigoJugador, String nombreJugador, Date fechaNacimiento,
			int aniosDeDebut, String nacionalidad, int dorsal, String posicion, int numeroGoles, int numeroFaltas) {
		super();
		this.idJugador = idJugador;
		this.codigoJugador = codigoJugador;
		this.nombreJugador = nombreJugador;
		this.fechaNacimiento = fechaNacimiento;
		this.aniosDeDebut = aniosDeDebut;
		this.nacionalidad = nacionalidad;
		this.dorsal = dorsal;
		this.posicion = posicion;
		this.numeroGoles = numeroGoles;
		this.numeroFaltas = numeroFaltas;
	}
	
	
	public JugadorModel(JugadorJPA jugador) {
		this.idJugador = jugador.getIdJugador();
		this.codigoJugador = jugador.getCodigoJugador();
		this.nombreJugador = jugador.getNombreJugador();
		this.fechaNacimiento = jugador.getFechaNacimiento();
		this.aniosDeDebut = jugador.getAniosDeDebut();
		this.nacionalidad = jugador.getNacionalidad();
		this.dorsal = jugador.getDorsal();
		this.posicion = jugador.getPosicion();
		this.numeroGoles = jugador.getNumeroGoles();
		this.numeroFaltas = jugador.getNumeroFaltas();
	}
	
	
	@Override
	public String toString() {
		return "JugadorModel [idJugador=" + idJugador + ", codigoJugador=" + codigoJugador + ", nombreJugador="
				+ nombreJugador + ", fechaNacimiento=" + fechaNacimiento + ", aniosDeDebut=" + aniosDeDebut
				+ ", nacionalidad=" + nacionalidad + ", dorsal=" + dorsal + ", posicion=" + posicion + ", numeroGoles="
				+ numeroGoles + ", numeroFaltas=" + numeroFaltas + "]";
	}
	
	
	

}
