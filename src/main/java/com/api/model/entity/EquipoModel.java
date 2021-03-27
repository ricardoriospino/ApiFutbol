package com.api.model.entity;

import java.io.Serializable;
import java.util.Date;

import com.api.jpa.entity.EquipoJPA;

public class EquipoModel implements Serializable {
	
	private int idEquipo;
	private String nombreEquipo;
	private Date anioFundacion;
	private int aniosExistencia;
	private String imagenEscudo;
	private String duenioActual;
	private String patrocinadorOficial;
	public int getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	public String getNombreEquipo() {
		return nombreEquipo;
	}
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	public Date getAnioFundacion() {
		return anioFundacion;
	}
	public void setAnioFundacion(Date anioFundacion) {
		this.anioFundacion = anioFundacion;
	}
	public int getAniosExistencia() {
		return aniosExistencia;
	}
	public void setAniosExistencia(int aniosExistencia) {
		this.aniosExistencia = aniosExistencia;
	}
	public String getImagenEscudo() {
		return imagenEscudo;
	}
	public void setImagenEscudo(String imagenEscudo) {
		this.imagenEscudo = imagenEscudo;
	}
	public String getDuenioActual() {
		return duenioActual;
	}
	public void setDuenioActual(String duenioActual) {
		this.duenioActual = duenioActual;
	}
	public String getPatrocinadorOficial() {
		return patrocinadorOficial;
	}
	public void setPatrocinadorOficial(String patrocinadorOficial) {
		this.patrocinadorOficial = patrocinadorOficial;
	}
	
	public EquipoModel() {
		
	}
	public EquipoModel(int idEquipo, String nombreEquipo, Date anioFundacion, int aniosExistencia, String imagenEscudo,
			String duenioActual, String patrocinadorOficial) {
		super();
		this.idEquipo = idEquipo;
		this.nombreEquipo = nombreEquipo;
		this.anioFundacion = anioFundacion;
		this.aniosExistencia = aniosExistencia;
		this.imagenEscudo = imagenEscudo;
		this.duenioActual = duenioActual;
		this.patrocinadorOficial = patrocinadorOficial;
	}
	
	public EquipoModel(EquipoJPA equipo) {
		this.idEquipo = equipo.getIdEquipo();
		this.nombreEquipo = equipo.getNombreEquipo();
		this.anioFundacion = equipo.getAnioFundacion();
		this.aniosExistencia = equipo.getAniosExistencia();
		this.imagenEscudo = equipo.getImagenEscudo();
		this.duenioActual = equipo.getDuenioActual();
		this.patrocinadorOficial = equipo.getPatrocinadorOficial();
	}
	@Override
	public String toString() {
		return "EquipoModel [idEquipo=" + idEquipo + ", nombreEquipo=" + nombreEquipo + ", anioFundacion="
				+ anioFundacion + ", aniosExistencia=" + aniosExistencia + ", imagenEscudo=" + imagenEscudo
				+ ", duenioActual=" + duenioActual + ", patrocinadorOficial=" + patrocinadorOficial + "]";
	}
	

}
