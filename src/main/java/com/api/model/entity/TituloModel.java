package com.api.model.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.api.jpa.entity.EquipoJPA;
import com.api.jpa.entity.TituloJPA;

public class TituloModel implements Serializable{
	
	private int idTitulo;
	
	@NotBlank
	private String anioTitulo;
	
	@NotBlank
	private String nombreTitulo;
	
	
	private boolean isNacional;
	
	// distintos al JPA
	private int idEquipo;
	
	@NotBlank
	private String codigoEquipo;
	
	private EquipoJPA equipo;

	


	public int getIdTitulo() {
		return idTitulo;
	}



	public void setIdTitulo(int idTitulo) {
		this.idTitulo = idTitulo;
	}

	public String getAnioTitulo() {
		return anioTitulo;
	}



	public void setAnioTitulo(String anioTitulo) {
		this.anioTitulo = anioTitulo;
	}



	public String getNombreTitulo() {
		return nombreTitulo;
	}



	public void setNombreTitulo(String nombreTitulo) {
		this.nombreTitulo = nombreTitulo;
	}

	

	public boolean isNacional() {
		return isNacional;
	}



	public void setNacional(boolean isNacional) {
		this.isNacional = isNacional;
	}



	public int getIdEquipo() {
		return idEquipo;
	}



	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}



	public EquipoJPA getEquipo() {
		return equipo;
	}



	public void setEquipo(EquipoJPA equipo) {
		this.equipo = equipo;
	}



	public TituloModel() {
		
	}
	
	
	
	public String getCodigoEquipo() {
		return codigoEquipo;
	}
	public void setCodigoEquipo(String codigoEquipo) {
		this.codigoEquipo = codigoEquipo;
	}
	


	



	public TituloModel(@NotBlank String anioTitulo, @NotBlank String nombreTitulo,  boolean isNacional) {
		super();
		this.anioTitulo = anioTitulo;
		this.nombreTitulo = nombreTitulo;
		this.isNacional = isNacional;
	}



	public TituloModel(TituloJPA titulo) {
		
		this.idTitulo = titulo.getIdTitulo();
		this.anioTitulo = titulo.getAnioTitulo();
		this.nombreTitulo = titulo.getNombreTitulo();
		this.isNacional = titulo.isTipoTitulo();
		this.idEquipo = titulo.getEquipo().getIdEquipo();
		this.codigoEquipo = titulo.getEquipo().getCodigoEquipo();
	}


	@Override
	public String toString() {
		return "TituloModel [idTitulo=" + idTitulo + ", anioTitulo=" + anioTitulo + ", nombreTitulo=" + nombreTitulo
				+ ", isNacional=" + isNacional + ", idEquipo=" + idEquipo + ", codigoEquipo=" + codigoEquipo
				+ ", equipo=" + equipo + "]";
	}


	
}
