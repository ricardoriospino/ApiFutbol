package com.api.model.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.api.jpa.entity.EntrenadorJPA;
import com.api.jpa.entity.EquipoJPA;
import com.api.jpa.entity.EquipoJugadorJPA;
import com.api.jpa.entity.JugadorJPA;

public class EquipoJugadorModel implements Serializable {

	private int idEquipoJugador;
	
	@NotBlank (message="codigo Jugador no puede ser vacio")
	private String codigoJugador;
	
	@NotBlank (message="codigo equipo no puede ser vacio")
	private String codigoEquipo;
	
	@NotNull  (message="Año no puede ser vacio")
	private int anio;
	
	private int idJugador;
	
	private int idEquipo;
	
	private JugadorJPA jugador;
	
	private EquipoJPA equipo;
	


	public int getIdEquipoJugador() {
		return idEquipoJugador;
	}

	public void setIdEquipoJugador(int idEquipoJugador) {
		this.idEquipoJugador = idEquipoJugador;
	}

	public String getCodigoJugador() {
		return codigoJugador;
	}

	public void setCodigoJugador(String codigoJugador) {
		this.codigoJugador = codigoJugador;
	}

	public String getCodigoEquipo() {
		return codigoEquipo;
	}

	public void setCodigoEquipo(String codigoEquipo) {
		this.codigoEquipo = codigoEquipo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public JugadorJPA getJugador() {
		return jugador;
	}

	public void setJugador(JugadorJPA jugador) {
		this.jugador = jugador;
	}

	public EquipoJPA getEquipo() {
		return equipo;
	}

	public void setEquipo(EquipoJPA equipo) {
		this.equipo = equipo;
	}

	
	
	public EquipoJugadorModel(int idEquipoJugador,
			@NotBlank(message = "codigo Jugador no puede ser vacio") String codigoJugador,
			@NotBlank(message = "codigo equipo no puede ser vacio") String codigoEquipo,
			@NotNull(message = "Año no puede ser vacio") int anio, int idJugador, int idEquipo, JugadorJPA jugador,
			EquipoJPA equipo) {
		super();
		this.idEquipoJugador = idEquipoJugador;
		this.codigoJugador = codigoJugador;
		this.codigoEquipo = codigoEquipo;
		this.anio = anio;
		this.idJugador = idJugador;
		this.idEquipo = idEquipo;
		this.jugador = jugador;
		this.equipo = equipo;
	}

	public EquipoJugadorModel (EquipoJugadorJPA equipoJugador) {
	
		this.idEquipoJugador= equipoJugador.getIdEquipoJugador();
		this.anio = equipoJugador.getAnio();
		this.codigoJugador = equipoJugador.getJugador().getCodigoJugador();
		this.codigoEquipo = equipoJugador.getEquipo().getCodigoEquipo();
		this.idEquipo = equipoJugador.getEquipo().getIdEquipo();
		this.idJugador = equipoJugador.getJugador().getIdJugador();
		
	}

	public EquipoJugadorModel() {
		
	}

	@Override
	public String toString() {
		return "EquipoJugadorModel [idEquipoJugador=" + idEquipoJugador + ", codigoJugador=" + codigoJugador
				+ ", codigoEquipo=" + codigoEquipo + ", anio=" + anio + ", idJugador=" + idJugador + ", idEquipo="
				+ idEquipo + ", jugador=" + jugador + ", equipo=" + equipo + "]";
	}

	
	
	
	
	
	
}
