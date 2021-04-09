package com.api.model.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.api.jpa.entity.PosicionesJPA;

public class PosicionesModel implements Serializable {
	
	private int idPosiciones;
	
	@NotNull (message="Temporada no puede ser vacio")
	private int temporada;
	
	@NotBlank (message="Nombre de Equipo no puede ser vacio")
	private String nombreEquipo;
	
	@NotNull (message="Partidos Jugados no puede ser vacio")
	private int partidosJugados;
	
	@NotNull (message="Partidos Ganados no puede ser vacio")
	private int partidosGanados;
	
	@NotNull (message="Partidos Empatados no puede ser vacio")
	private int partidosEmpatados;
	
	@NotNull (message="Partidos Perdidos no puede ser vacio")
	private int partidosPerdidos;
	
	@NotNull (message="Puntos no puede ser vacio")
	private int puntos;
	
	public int getIdPosiciones() {
		return idPosiciones;
	}
	public void setIdPosiciones(int idPosiciones) {
		this.idPosiciones = idPosiciones;
	}
	public int getTemporada() {
		return temporada;
	}
	public void setTemporada(int temporada) {
		this.temporada = temporada;
	}
	public String getNombreEquipo() {
		return nombreEquipo;
	}
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	public int getPartidosJugados() {
		return partidosJugados;
	}
	public void setPartidosJugados(int partidosJugados) {
		this.partidosJugados = partidosJugados;
	}
	public int getPartidosGanados() {
		return partidosGanados;
	}
	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}
	public int getPartidosEmpatados() {
		return partidosEmpatados;
	}
	public void setPartidosEmpatados(int partidosEmpatados) {
		this.partidosEmpatados = partidosEmpatados;
	}
	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}
	public void setPartidosPerdidos(int partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	

	public PosicionesModel(int idPosiciones, @NotNull(message = "Temporada no puede ser vacio") int temporada,
			@NotBlank(message = "Nombre de Equipo no puede ser vacio") String nombreEquipo,
			@NotNull(message = "Partidos Jugados no puede ser vacio") int partidosJugados,
			@NotNull(message = "Partidos Ganados no puede ser vacio") int partidosGanados,
			@NotNull(message = "Partidos Empatados no puede ser vacio") int partidosEmpatados,
			@NotNull(message = "Partidos Perdidos no puede ser vacio") int partidosPerdidos,
			@NotNull(message = "Puntos no puede ser vacio") int puntos) {
		super();
		this.idPosiciones = idPosiciones;
		this.temporada = temporada;
		this.nombreEquipo = nombreEquipo;
		this.partidosJugados = partidosJugados;
		this.partidosGanados = partidosGanados;
		this.partidosEmpatados = partidosEmpatados;
		this.partidosPerdidos = partidosPerdidos;
		this.puntos = puntos;
	}
	
	
	public PosicionesModel (PosicionesJPA posiciones) {
		this.idPosiciones = posiciones.getIdPosiciones();
		this.temporada = posiciones.getTemporada();
		this.nombreEquipo = posiciones.getNombreEquipo();
		this.partidosJugados = posiciones.getPartidosJugados();
		this.partidosGanados = posiciones.getPartidosGanados();
		this.partidosEmpatados = posiciones.getPartidosEmpatados();
		this.partidosPerdidos = posiciones.getPartidosPerdidos();
		this.puntos = posiciones.getPuntos();
	}
	@Override
	public String toString() {
		return "PosicionesModel [idPosiciones=" + idPosiciones + ", temporada=" + temporada + ", nombreEquipo="
				+ nombreEquipo + ", partidosJugados=" + partidosJugados + ", partidosGanados=" + partidosGanados
				+ ", partidosEmpatados=" + partidosEmpatados + ", partidosPerdidos=" + partidosPerdidos + ", puntos="
				+ puntos + "]";
	}
	
	
}
