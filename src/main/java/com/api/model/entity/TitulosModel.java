package com.api.model.entity;

import java.io.Serializable;

import com.api.jpa.entity.EquipoJPA;
import com.api.jpa.entity.TitulosJPA;

public class TitulosModel implements Serializable{
	
	private int idTitulo;
	private String anio_titulo;
	private String nombreTitulo;
	private boolean tipoTitulo;
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
	public String getNombreTitulo() {
		return nombreTitulo;
	}
	public void setNombreTitulo(String nombreTitulo) {
		this.nombreTitulo = nombreTitulo;
	}
	public boolean isTipoTitulo() {
		return tipoTitulo;
	}
	public void setTipoTitulo(boolean tipoTitulo) {
		this.tipoTitulo = tipoTitulo;
	}
	public EquipoJPA getEquipo() {
		return equipo;
	}
	public void setEquipo(EquipoJPA equipo) {
		this.equipo = equipo;
	}
	
	
	public TitulosModel() {
		
	}
	
	
	public TitulosModel(int idTitulo, String anio_titulo, String nombreTitulo, boolean tipoTitulo, EquipoJPA equipo) {
		super();
		this.idTitulo = idTitulo;
		this.anio_titulo = anio_titulo;
		this.nombreTitulo = nombreTitulo;
		this.tipoTitulo = tipoTitulo;
		this.equipo = equipo;
	}
	public TitulosModel(TitulosJPA titulos) {
		this.idTitulo = titulos.getIdTitulo();
		this.anio_titulo = titulos.getAnio_titulo();
		this.nombreTitulo = titulos.getNombreTitulo();
		this.tipoTitulo = titulos.isTipoTitulo();
		this.equipo = titulos.getEquipo();
	}
	
	
	@Override
	public String toString() {
		return "TitulosModel [idTitulo=" + idTitulo + ", anio_titulo=" + anio_titulo + ", nombreTitulo=" + nombreTitulo
				+ ", tipoTitulo=" + tipoTitulo + ", equipo=" + equipo + "]";
	}
	
	
	

}
