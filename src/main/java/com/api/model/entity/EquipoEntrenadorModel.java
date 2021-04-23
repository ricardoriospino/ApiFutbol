package com.api.model.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.api.jpa.entity.EntrenadorJPA;
import com.api.jpa.entity.EquipoEntrenadorJPA;
import com.api.jpa.entity.EquipoJPA;

public class EquipoEntrenadorModel implements Serializable {
	
	private int idEquipoEntrenador;
	
	@NotBlank (message="codigo entrenador no puede ser vacio")
	private String codigoEntrenador;
	
	@NotBlank (message="codigo equipo no puede ser vacio")
	private String codigoEquipo;
	
	@NotNull  (message="Año no puede ser vacio")
	private int anio;
	
	@NotNull  (message="Partidos jugados no puede ser vacio")
	private int partidosJugados;
	
	private int idEntrenador;
	
	private int idEquipo;
	
	private EntrenadorJPA entrenador;
	
	private EquipoJPA equipo;
	
	public EquipoEntrenadorModel() {
		
	}
	

	public int getIdEquipoEntrenador() {
		return idEquipoEntrenador;
	}
	public void setIdEquipoEntrenador(int idEquipoEntrenador) {
		this.idEquipoEntrenador = idEquipoEntrenador;
	}
	
	public String getCodigoEntrenador() {
		return codigoEntrenador;
	}
	public void setCodigoEntrenador(String codigoEntrenador) {
		this.codigoEntrenador = codigoEntrenador;
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
	public int getPartidosJugados() {
		return partidosJugados;
	}
	public void setPartidosJugados(int partidosJugados) {
		this.partidosJugados = partidosJugados;
	}
	
	public EntrenadorJPA getEntrenador() {
		return entrenador;
	}


	public void setEntrenador(EntrenadorJPA entrenador) {
		this.entrenador = entrenador;
	}


	public EquipoJPA getEquipo() {
		return equipo;
	}


	public void setEquipo(EquipoJPA equipo) {
		this.equipo = equipo;
	}
	
	public int getIdEntrenador() {
		return idEntrenador;
	}


	public void setIdEntrenador(int idEntrenador) {
		this.idEntrenador = idEntrenador;
	}


	public int getIdEquipo() {
		return idEquipo;
	}


	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}


	public EquipoEntrenadorModel(int idEquipoEntrenador,
			@NotBlank(message = "codigo entrenador no puede ser vacio") String codigoEntrenador,
			@NotBlank(message = "codigo equipo no puede ser vacio") String codigoEquipo,
			@NotNull(message = "Año no puede ser vacio") int anio,
			@NotNull(message = "Partidos jugados no puede ser vacio") int partidosJugados, int idEntrenador,
			int idEquipo, EntrenadorJPA entrenador, EquipoJPA equipo) {
		super();
		this.idEquipoEntrenador = idEquipoEntrenador;
		this.codigoEntrenador = codigoEntrenador;
		this.codigoEquipo = codigoEquipo;
		this.anio = anio;
		this.partidosJugados = partidosJugados;
		this.idEntrenador = idEntrenador;
		this.idEquipo = idEquipo;
		this.entrenador = entrenador;
		this.equipo = equipo;
	}


	public EquipoEntrenadorModel(EquipoEntrenadorJPA equipoEntrenador) {
		this.idEquipoEntrenador = equipoEntrenador.getIdEquipoEntrenador();
		this.anio = equipoEntrenador.getAnio();
		this.partidosJugados = equipoEntrenador.getPartidosJugados();
		this.idEntrenador = equipoEntrenador.getEntrenador().getIdEntrenador();
		this.idEquipo = equipoEntrenador.getEquipo().getIdEquipo();
		this.codigoEntrenador = equipoEntrenador.getEntrenador().getCodigoEntrenador();
		this.codigoEquipo = equipoEntrenador.getEquipo().getCodigoEquipo();
	}


	@Override
	public String toString() {
		return "EquipoEntrenadorModel [idEquipoEntrenador=" + idEquipoEntrenador + ", codigoEntrenador="
				+ codigoEntrenador + ", codigoEquipo=" + codigoEquipo + ", anio=" + anio + ", partidosJugados="
				+ partidosJugados + ", idEntrenador=" + idEntrenador + ", idEquipo=" + idEquipo + ", entrenador="
				+ entrenador + ", equipo=" + equipo + "]";
	}




}
