package com.api.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name="tb_equipo_jugador")
public class EquipoJugadorJPA implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_equipo_jugador")
	private int idEquipoJugador;
	
	@JoinColumn(name="id_equipo", referencedColumnName = "id_equipo")
	@ManyToOne
	private EquipoJPA equipo;
	
	@JoinColumn(name="id_jugador", referencedColumnName = "id_jugador")
	@ManyToOne
	private JugadorJPA jugador;
	
	@Column(name="anio" , nullable=false , length= 10  )
	private int anio;
	
	public EquipoJugadorJPA() {
		
	}
	
	

	public EquipoJugadorJPA(int idEquipoJugador, EquipoJPA equipo, JugadorJPA jugador, int anio) {
		super();
		this.idEquipoJugador = idEquipoJugador;
		this.equipo = equipo;
		this.jugador = jugador;
		this.anio = anio;
	}



	// aqui va EquipoJugadorJpa a EquipoJugadorModel

	public int getIdEquipoJugador() {
		return idEquipoJugador;
	}

	public void setIdEquipoJugador(int idEquipoJugador) {
		this.idEquipoJugador = idEquipoJugador;
	}

	public EquipoJPA getEquipo() {
		return equipo;
	}

	public void setEquipo(EquipoJPA equipo) {
		this.equipo = equipo;
	}

	public JugadorJPA getJugador() {
		return jugador;
	}

	public void setJugador(JugadorJPA jugador) {
		this.jugador = jugador;
	}
	

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}



	@Override
	public String toString() {
		return "EquipoJugadorJPA [idEquipoJugador=" + idEquipoJugador + ", equipo=" + equipo + ", jugador=" + jugador
				+ ", anio=" + anio + "]";
	}

	
	
}
