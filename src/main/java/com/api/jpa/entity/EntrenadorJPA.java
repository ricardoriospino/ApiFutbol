package com.api.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.api.model.entity.EntrenadorModel;
@Entity
@Table(name = "tb_entrenador")
public class EntrenadorJPA implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_entrenador")
	private int idEntrenador;
	
	@Column (name="nombre_entrenador" , nullable=false , length= 50 )
	private String nombreEntrenador;
	
	@Column (name="edad" , nullable=false , length= 10 )
	private int edad;
	
	@Column (name="nacionalidad" , nullable=false , length= 50 )
	private String nacionalidad;
	
	@Column (name="anios_experiencia" , nullable=false , length= 10 )
	private int aniosExperiencia;
	
	@Column (name="titulos_ganados" , nullable=false , length= 10 )
	private int titulosGanados;
	
	public EntrenadorJPA() {
		
	}

	public EntrenadorJPA(int idEntrenador, String nombreEntrenador, int edad, String nacionalidad, int aniosExperiencia,
			int titulosGanados) {
		super();
		this.idEntrenador = idEntrenador;
		this.nombreEntrenador = nombreEntrenador;
		this.edad = edad;
		this.nacionalidad = nacionalidad;
		this.aniosExperiencia = aniosExperiencia;
		this.titulosGanados = titulosGanados;
	}

	public EntrenadorJPA( EntrenadorModel entrenador) {
		this.idEntrenador = entrenador.getIdEntrenador();
		this.nombreEntrenador = entrenador.getNombreEntrenador();
		this.edad = entrenador.getEdad();
		this.nacionalidad = entrenador.getNacionalidad();
		this.aniosExperiencia = entrenador.getAniosExperiencia();
		this.titulosGanados = entrenador.getTitulosGanados();
	}

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



	@Override
	public String toString() {
		return "EntrenadorJPA [idEntrenador=" + idEntrenador + ", nombreEntrenador=" + nombreEntrenador + ", edad="
				+ edad + ", nacionalidad=" + nacionalidad + ", aniosExperiencia=" + aniosExperiencia
				+ ", titulosGanados=" + titulosGanados + "]";
	}




}
