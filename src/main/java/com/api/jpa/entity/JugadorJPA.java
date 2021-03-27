package com.api.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.api.model.entity.JugadorModel;

@Entity
@Table(name = "tb_jugador")
public class JugadorJPA implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_jugador")
	private int idJugador;
	
	@Column (name="nombre_jugador" , nullable=false , length= 50 )
	private String nombreJugador;
	
	@Column (name="edad" , nullable=false , length= 10 )
	private int edad;
	
	@Column (name="anios_de_carrera" , nullable=false , length= 10 )
	private int aniosDeCarrera;
	
	@Column (name="nacionalidad" , nullable=false , length= 50 )
	private String nacionalidad;
	
	@Column (name="dorsal" , nullable=false , length= 10 )
	private int dorsal;

	@Column (name="posicion" , nullable=false , length= 50 )
	private String posicion;
	
	public JugadorJPA() {
		
	}

	public JugadorJPA(int idJugador, String nombreJugador, int edad, int aniosDeCarrera, String nacionalidad,
			int dorsal, String posicion) {
		super();
		this.idJugador = idJugador;
		this.nombreJugador = nombreJugador;
		this.edad = edad;
		this.aniosDeCarrera = aniosDeCarrera;
		this.nacionalidad = nacionalidad;
		this.dorsal = dorsal;
		this.posicion = posicion;
	}
	
	public JugadorJPA(JugadorModel jugador) {
		this.idJugador = jugador.getIdJugador();
		this.nombreJugador = jugador.getNombreJugador();
		this.edad = jugador.getEdad();
		this.aniosDeCarrera = jugador.getAniosDeCarrera();
		this.nacionalidad = jugador.getNacionalidad();
		this.dorsal = jugador.getDorsal();
		this.posicion = jugador.getPosicion();
	}

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getAniosDeCarrera() {
		return aniosDeCarrera;
	}

	public void setAniosDeCarrera(int aniosDeCarrera) {
		this.aniosDeCarrera = aniosDeCarrera;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	@Override
	public String toString() {
		return "JugadorJPA [idJugador=" + idJugador + ", nombreJugador=" + nombreJugador + ", edad=" + edad
				+ ", aniosDeCarrera=" + aniosDeCarrera + ", nacionalidad=" + nacionalidad + ", dorsal=" + dorsal
				+ ", posicion=" + posicion + "]";
	}
	
}
