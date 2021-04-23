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

import com.api.model.entity.EquipoEstadioModel;

@Entity
@Table (name="tb_equipo_estadio")
public class EquipoEstadioJPA implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_equipo_estadio")
	private int idEquipoEstadio;
	
	@JoinColumn(name="id_equipo", referencedColumnName = "id_equipo")
	@ManyToOne
	private EquipoJPA equipo;
	
	@JoinColumn(name="id_estadio", referencedColumnName = "id_estadio")
	@ManyToOne
	private EstadioJPA estadio;
	
	public EquipoEstadioJPA() {
		
	}

	public EquipoEstadioJPA(int idEquipoEstadio, EquipoJPA equipo, EstadioJPA estadio) {
		super();
		this.idEquipoEstadio = idEquipoEstadio;
		this.equipo = equipo;
		this.estadio = estadio;
	}
	
	public EquipoEstadioJPA(EquipoJPA equipo, EstadioJPA estadio) {
		super();
		this.equipo = equipo;
		this.estadio = estadio;
	}
	
	public EquipoEstadioJPA (EquipoEstadioModel equipoEstadio) {
		this.idEquipoEstadio = equipoEstadio.getIdEquipoEstadio();
		this.equipo = equipoEstadio.getEquipo();
		this.estadio = equipoEstadio.getEstadio();
	}



	public int getIdEquipoEstadio() {
		return idEquipoEstadio;
	}

	public void setIdEquipoEstadio(int idEquipoEstadio) {
		this.idEquipoEstadio = idEquipoEstadio;
	}

	public EquipoJPA getEquipo() {
		return equipo;
	}

	public void setEquipo(EquipoJPA equipo) {
		this.equipo = equipo;
	}

	public EstadioJPA getEstadio() {
		return estadio;
	}

	public void setEstadio(EstadioJPA estadio) {
		this.estadio = estadio;
	}

	@Override
	public String toString() {
		return "EquipoEstadioJPA [idEquipoEstadio=" + idEquipoEstadio + ", equipo=" + equipo + ", estadio=" + estadio
				+ "]";
	}
	
	

}
