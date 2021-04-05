package com.api.model.entity;

import java.io.Serializable;
import java.util.Date;

import com.api.jpa.entity.EntrenadorJPA;

public class EntrenadorModel implements Serializable {
	
	private int idEntrenador;
	private String codigoEntrenador;
	private String nombreEntrenador;
	private Date fechaNacimiento;
	private String nacionalidad;
	private Date aniosInicioLaboral;
	private int titulosGanados;
	
	
	
	
	public int getIdEntrenador() {
		return idEntrenador;
	}

	public void setIdEntrenador(int idEntrenador) {
		this.idEntrenador = idEntrenador;
	}

	public String getCodigoEntrenador() {
		return codigoEntrenador;
	}

	public void setCodigoEntrenador(String codigoEntrenador) {
		this.codigoEntrenador = codigoEntrenador;
	}

	public String getNombreEntrenador() {
		return nombreEntrenador;
	}

	public void setNombreEntrenador(String nombreEntrenador) {
		this.nombreEntrenador = nombreEntrenador;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	
	public Date getAniosInicioLaboral() {
		return aniosInicioLaboral;
	}

	public void setAniosInicioLaboral(Date aniosInicioLaboral) {
		this.aniosInicioLaboral = aniosInicioLaboral;
	}

	public int getTitulosGanados() {
		return titulosGanados;
	}

	public void setTitulosGanados(int titulosGanados) {
		this.titulosGanados = titulosGanados;
	}
	

	

	public EntrenadorModel(int idEntrenador, String codigoEntrenador, String nombreEntrenador, Date fechaNacimiento,
			String nacionalidad, Date aniosInicioLaboral, int titulosGanados) {
		super();
		this.idEntrenador = idEntrenador;
		this.codigoEntrenador = codigoEntrenador;
		this.nombreEntrenador = nombreEntrenador;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.aniosInicioLaboral = aniosInicioLaboral;
		this.titulosGanados = titulosGanados;
	}

	// para convertir de un objeto a otro
	public EntrenadorModel(EntrenadorJPA entrenador) {
		this.idEntrenador = entrenador.getIdEntrenador();
		this.codigoEntrenador = entrenador.getCodigoEntrenador();
		this.nombreEntrenador = entrenador.getNombreEntrenador();
		this.fechaNacimiento = entrenador.getFechaNacimiento();
		this.nacionalidad = entrenador.getNacionalidad();
		this.aniosInicioLaboral = entrenador.getAniosInicioLaboral();
		this.titulosGanados = entrenador.getTitulosGanados();
	}

	@Override
	public String toString() {
		return "EntrenadorModel [idEntrenador=" + idEntrenador + ", codigoEntrenador=" + codigoEntrenador
				+ ", nombreEntrenador=" + nombreEntrenador + ", fechaNacimiento=" + fechaNacimiento + ", nacionalidad="
				+ nacionalidad + ", aniosInicioLaboral=" + aniosInicioLaboral + ", titulosGanados=" + titulosGanados
				+ "]";
	}
	
	
	
}
