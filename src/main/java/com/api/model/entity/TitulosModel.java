package com.api.model.entity;

import java.io.Serializable;

import com.api.jpa.entity.EquipoJPA;
import com.api.jpa.entity.TitulosJPA;

public class TitulosModel implements Serializable{
	
	private int idTitulo;
	private String anio_titulo;
	private EquipoJPA equipo;
	
	public int getIdTitulo() {
		return idTitulo;
	}
	public void setIdTitulo(int idTitulo) {
		this.idTitulo = idTitulo;
	}
	public String getAnio_titulo() {
		return anio_titulo;
	}
	public void setAnio_titulo(String anio_titulo) {
		this.anio_titulo = anio_titulo;
	}
	public EquipoJPA getEquipo() {
		return equipo;
	}
	public void setEquipo(EquipoJPA equipo) {
		this.equipo = equipo;
	}
	
	public TitulosModel() {
		
	}
	public TitulosModel(int idTitulo, String anio_titulo, EquipoJPA equipo) {
		super();
		this.idTitulo = idTitulo;
		this.anio_titulo = anio_titulo;
		this.equipo = equipo;
	}
	
	public TitulosModel(TitulosJPA titulos) {
		this.idTitulo = titulos.getIdTitulo();
		this.anio_titulo = titulos.getAnio_titulo();
		this.equipo = titulos.getEquipo();
	}
	@Override
	public String toString() {
		return "TitulosModel [idTitulo=" + idTitulo + ", anio_titulo=" + anio_titulo + ", equipo=" + equipo + "]";
	}
	
	
	
	

}
