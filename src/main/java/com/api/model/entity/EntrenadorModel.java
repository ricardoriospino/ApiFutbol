package com.api.model.entity;

import java.io.Serializable;

import com.api.jpa.entity.EntrenadorJPA;

public class EntrenadorModel implements Serializable {
	
	private int idEntrenador;
	private String nombreEntrenador;
	private int edad;
	private String nacionalidad;
	private int aniosExperiencia;
	private int titulosGanados;
	public int getIdEntrenador() {
		return idEntrenador;
	}
	public void setIdEntrenador(int idEntrenador) {
		this.idEntrenador = idEntrenador;
	}
	public String getNombreEntrenador() {
		return nombreEntrenador;
	}
	public void setNombreEntrenador(String nombreEntrenador) {
		this.nombreEntrenador = nombreEntrenador;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public int getAniosExperiencia() {
		return aniosExperiencia;
	}
	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}
	public int getTitulosGanados() {
		return titulosGanados;
	}
	public void setTitulosGanados(int titulosGanados) {
		this.titulosGanados = titulosGanados;
	}
	public EntrenadorModel(int idEntrenador, String nombreEntrenador, int edad, String nacionalidad,
			int aniosExperiencia, int titulosGanados) {
		super();
		this.idEntrenador = idEntrenador;
		this.nombreEntrenador = nombreEntrenador;
		this.edad = edad;
		this.nacionalidad = nacionalidad;
		this.aniosExperiencia = aniosExperiencia;
		this.titulosGanados = titulosGanados;
	}
	
	// para convertir de un objeto a otro
	public EntrenadorModel(EntrenadorJPA entrenador) {
		this.idEntrenador = entrenador.getIdEntrenador();
		this.nombreEntrenador = entrenador.getNombreEntrenador();
		this.edad = entrenador.getEdad();
		this.nacionalidad = entrenador.getNacionalidad();
		this.aniosExperiencia = entrenador.getAniosExperiencia();
		this.titulosGanados = entrenador.getTitulosGanados();
	}
	@Override
	public String toString() {
		return "EntrenadorModel [idEntrenador=" + idEntrenador + ", nombreEntrenador=" + nombreEntrenador + ", edad="
				+ edad + ", nacionalidad=" + nacionalidad + ", aniosExperiencia=" + aniosExperiencia
				+ ", titulosGanados=" + titulosGanados + "]";
	}
	
	
}
