package com.api.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.api.model.entity.PosicionesModel;

@Entity
@Table(name = "tb_posiciones")
public class PosicionesJPA implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_posiciones")
	private int idPosiciones;
	
	@Column (name="temporada" , nullable=false , length= 10 )
	private int temporada;
	
	@Column (name="nombre_equipo" , nullable=false , length= 50 )
	private String nombreEquipo;
	
	@Column (name="partidos_jugados" , nullable=false , length= 10 )
	private int partidosJugados;
	
	@Column (name="partidos_ganados" , nullable=false , length= 10 )
	private int partidosGanados;
	
	@Column (name="partidos_empatados" , nullable=false , length= 10 )
	private int partidosEmpatados;
	
	@Column (name="partidos_perdidos" , nullable=false , length= 10 )
	private int partidosPerdidos;
	
	@Column (name="puntos" , nullable=false , length= 10 )
	private int puntos;
	
	public PosicionesJPA() {
		
	}

	public PosicionesJPA(int idPosiciones, int temporada, String nombreEquipo, int partidosJugados, int partidosGanados,
			int partidosEmpatados, int partidosPerdidos, int puntos) {
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
	
	public PosicionesJPA (PosicionesModel posiciones) {
		this.idPosiciones = posiciones.getIdPosiciones();
		this.temporada = posiciones.getTemporada();
		this.nombreEquipo = posiciones.getNombreEquipo();
		this.partidosJugados = posiciones.getPartidosJugados();
		this.partidosGanados = posiciones.getPartidosGanados();
		this.partidosEmpatados = posiciones.getPartidosEmpatados();
		this.partidosPerdidos = posiciones.getPartidosPerdidos();
		this.puntos = posiciones.getPuntos();
	}

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

	@Override
	public String toString() {
		return "PosicionesJPA [idPosiciones=" + idPosiciones + ", temporada=" + temporada + ", nombreEquipo="
				+ nombreEquipo + ", partidosJugados=" + partidosJugados + ", partidosGanados=" + partidosGanados
				+ ", partidosEmpatados=" + partidosEmpatados + ", partidosPerdidos=" + partidosPerdidos + ", puntos="
				+ puntos + "]";
	}
	
	

}
