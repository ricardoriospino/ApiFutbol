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

import com.api.model.entity.EquipoEntrenadorModel;

@Entity
@Table (name="tb_equipo_entrenador")
public class EquipoEntrenadorJPA implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_equipo_entrenador")
	private int idEquipoEntrenador;
	
	@JoinColumn(name="id_equipo", referencedColumnName = "id_equipo")
	@ManyToOne
	private EquipoJPA equipo;
	
	@JoinColumn(name="id_entrenador", referencedColumnName = "id_entrenador")
	@ManyToOne
	private EntrenadorJPA entrenador;
	
	@Column(name="anio" , nullable=false , length= 10  )
	private int anio;
	
	@Column(name="partidos_jugados" , nullable=false , length=10)
	private int partidosJugados;
	
	public EquipoEntrenadorJPA() {
		
	}

	public EquipoEntrenadorJPA(EquipoEntrenadorModel equipoEntrenador) {
		this.idEquipoEntrenador = equipoEntrenador.getIdEquipoEntrenador();
		this.equipo = equipoEntrenador.getEquipo();
		this.entrenador = equipoEntrenador.getEntrenador();
		this.anio = equipoEntrenador.getAnio();
		this.partidosJugados = equipoEntrenador.getPartidosJugados();
	
	}
	
	public EquipoEntrenadorJPA(int idEquipoEntrenador, EquipoJPA equipo, EntrenadorJPA entrenador, int anio,
			 int partidosJugados) {
		super();
		this.idEquipoEntrenador = idEquipoEntrenador;
		this.equipo = equipo;
		this.entrenador = entrenador;
		this.anio = anio;
		this.partidosJugados = partidosJugados;
	}
	
	public EquipoEntrenadorJPA(EquipoJPA equipo, EntrenadorJPA entrenador, int anio, int partidosJugados) {
		super();
		this.equipo = equipo;
		this.entrenador = entrenador;
		this.anio = anio;
		this.partidosJugados = partidosJugados;
	}


	public int getIdEquipoEntrenador() {
		return idEquipoEntrenador;
	}

	public void setIdEquipoEntrenador(int idEquipoEntrenador) {
		this.idEquipoEntrenador = idEquipoEntrenador;
	}



	public EquipoJPA getEquipo() {
		return equipo;
	}



	public void setEquipo(EquipoJPA equipo) {
		this.equipo = equipo;
	}



	public EntrenadorJPA getEntrenador() {
		return entrenador;
	}



	public void setEntrenador(EntrenadorJPA entrenador) {
		this.entrenador = entrenador;
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



	@Override
	public String toString() {
		return "EquipoEntrenadorJPA [idEquipoEntrenador=" + idEquipoEntrenador + ", equipo=" + equipo + ", entrenador="
				+ entrenador + ", anio=" + anio + ", partidosJugados="
				+ partidosJugados + "]";
	}


	
	

}
