package com.api.model.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.api.jpa.entity.JugadorJPA;

public class JugadorModel implements Serializable {
	
	private int idJugador;
	
	
	private String codigoJugador;
	
	@NotBlank (message="Nombre de Jugador no puede ser vacio")
	private String nombreJugador;
	
	@NotBlank (message="fecha de Nacimiento de Jugador no puede ser vacio")
	private String fechaNacimiento;
	
	@NotNull (message="Año de debut de Jugador no puede ser vacio")
	private int aniosDeDebut;
	
	@NotBlank (message="Nacionalidad de Jugador no puede ser vacio")
	private String nacionalidad;
	
	@NotNull (message="Dorsal de Jugador no puede ser vacio")
	private int dorsal;
	
	@NotBlank(message="Posicion de Jugador no puede ser vacio")
	private String posicion;
	
	@NotNull (message="Numero de Goles de Jugador no puede ser vacio")
	private int numeroGoles;
	
	@NotNull (message="Numero de Faltas de Jugador no puede ser vacio")
	private int numeroFaltas;
	
	
	
	
	
	public JugadorModel() {
		
	}
	

	public JugadorModel(int idJugador,  String codigoJugador,
			@NotBlank(message = "Nombre de Jugador no puede ser vacio") String nombreJugador,
			@NotBlank(message = "fecha de Nacimiento de Jugador no puede ser vacio") String fechaNacimiento,
			@NotNull(message = "Año de debut de Jugador no puede ser vacio") int aniosDeDebut,
			@NotBlank(message = "Nacionalidad de Jugador no puede ser vacio") String nacionalidad,
			@NotNull(message = "Dorsal de Jugador no puede ser vacio") int dorsal,
			@NotBlank(message = "Posicion de Jugador no puede ser vacio") String posicion,
			@NotNull(message = "Numero de Goles de Jugador no puede ser vacio") int numeroGoles,
			@NotNull(message = "Numero de Faltas de Jugador no puede ser vacio") int numeroFaltas) {
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		this.idJugador = jugador.getIdJugador();
		this.codigoJugador = jugador.getCodigoJugador();
		this.nombreJugador = jugador.getNombreJugador();
		this.fechaNacimiento = sdf.format(jugador.getFechaNacimiento());
		this.aniosDeDebut = jugador.getAniosDeDebut();
		this.nacionalidad = jugador.getNacionalidad();
		this.dorsal = jugador.getDorsal();
		this.posicion = jugador.getPosicion();
		this.numeroGoles = jugador.getNumeroGoles();
		this.numeroFaltas = jugador.getNumeroFaltas();
	}
	
	
	
	
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


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
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


	@Override
	public String toString() {
		return "JugadorModel [idJugador=" + idJugador + ", codigoJugador=" + codigoJugador + ", nombreJugador="
				+ nombreJugador + ", fechaNacimiento=" + fechaNacimiento + ", aniosDeDebut=" + aniosDeDebut
				+ ", nacionalidad=" + nacionalidad + ", dorsal=" + dorsal + ", posicion=" + posicion + ", numeroGoles="
				+ numeroGoles + ", numeroFaltas=" + numeroFaltas + "]";
	}
	
	
	

}
