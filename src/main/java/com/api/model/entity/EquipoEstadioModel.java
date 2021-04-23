package com.api.model.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.api.jpa.entity.EquipoEstadioJPA;
import com.api.jpa.entity.EquipoJPA;
import com.api.jpa.entity.EstadioJPA;

public class EquipoEstadioModel implements Serializable {
	
	private int idEquipoEstadio;
	
	@NotBlank (message="codigo estadio no puede ser vacio")
	private String codigoEstadio;
	
	@NotBlank (message="codigo equipo no puede ser vacio")
	private String codigoEquipo;
	
	private int idEstadio;
	
	private int idEquipo;
	
	private EstadioJPA estadio;
	
	private EquipoJPA equipo;
	

	public int getIdEquipoEstadio() {
		return idEquipoEstadio;
	}

	public void setIdEquipoEstadio(int idEquipoEstadio) {
		this.idEquipoEstadio = idEquipoEstadio;
	}

	public String getCodigoEstadio() {
		return codigoEstadio;
	}

	public void setCodigoEstadio(String codigoEstadio) {
		this.codigoEstadio = codigoEstadio;
	}

	public String getCodigoEquipo() {
		return codigoEquipo;
	}

	public void setCodigoEquipo(String codigoEquipo) {
		this.codigoEquipo = codigoEquipo;
	}

	public int getIdEstadio() {
		return idEstadio;
	}

	public void setIdEstadio(int idEstadio) {
		this.idEstadio = idEstadio;
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public EstadioJPA getEstadio() {
		return estadio;
	}

	public void setEstadio(EstadioJPA estadio) {
		this.estadio = estadio;
	}

	public EquipoJPA getEquipo() {
		return equipo;
	}

	public void setEquipo(EquipoJPA equipo) {
		this.equipo = equipo;
	}


	public EquipoEstadioModel(int idEquipoEstadio,
			@NotBlank(message = "codigo estadio no puede ser vacio") String codigoEstadio,
			@NotBlank(message = "codigo equipo no puede ser vacio") String codigoEquipo, int idEstadio, int idEquipo,
			EstadioJPA estadio, EquipoJPA equipo) {
		super();
		this.idEquipoEstadio = idEquipoEstadio;
		this.codigoEstadio = codigoEstadio;
		this.codigoEquipo = codigoEquipo;
		this.idEstadio = idEstadio;
		this.idEquipo = idEquipo;
		this.estadio = estadio;
		this.equipo = equipo;
	}

	public EquipoEstadioModel() {
		
	}
	
	
	public EquipoEstadioModel (EquipoEstadioJPA equipoEstadio) {
		this.idEquipoEstadio = equipoEstadio.getIdEquipoEstadio();
		this.idEstadio = equipoEstadio.getEstadio().getIdEstadio();
		this.idEquipo = equipoEstadio.getEquipo().getIdEquipo();
		this.codigoEstadio = equipoEstadio.getEstadio().getCodigoEstadio();
		this.codigoEquipo = equipoEstadio.getEquipo().getCodigoEquipo();
	}

	@Override
	public String toString() {
		return "EquipoEstadioModel [idEquipoEstadio=" + idEquipoEstadio + ", codigoEstadio=" + codigoEstadio
				+ ", codigoEquipo=" + codigoEquipo + ", idEstadio=" + idEstadio + ", idEquipo=" + idEquipo
				+ ", estadio=" + estadio + ", equipo=" + equipo + "]";
	}
	
	
	
	
	

}
