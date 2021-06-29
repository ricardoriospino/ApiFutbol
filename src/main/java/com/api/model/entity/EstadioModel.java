package com.api.model.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.api.jpa.entity.EstadioJPA;

public class EstadioModel implements Serializable {
	
	
	private int idEstadio;
	
	
	private String codigoEstadio;
	
	@NotBlank (message="Nombre de estadio no puede ser vacio")
	private String nombreEstadio;
	
	@NotNull  (message="capacidad de estadio no puede ser vacio")
	private int capacidad;
	
	@NotBlank (message="ubicacion de estadio no puede ser vacio")
	private String ubicacion;
	
	
	
	
	public int getIdEstadio() {
		return idEstadio;
	}
	public void setIdEstadio(int idEstadio) {
		this.idEstadio = idEstadio;
	}
	public String getCodigoEstadio() {
		return codigoEstadio;
	}
	public void setCodigoEstadio(String codigoEstadio) {
		this.codigoEstadio = codigoEstadio;
	}
	public String getNombreEstadio() {
		return nombreEstadio;
	}
	public void setNombreEstadio(String nombreEstadio) {
		this.nombreEstadio = nombreEstadio;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public EstadioModel() {
		
	}
	
	
	
	public EstadioModel(int idEstadio,  String codigoEstadio,
			@NotBlank(message = "Nombre de estadio no puede ser vacio") String nombreEstadio,
			@NotNull(message = "capacidad de estadio no puede ser vacio") int capacidad,
			@NotBlank(message = "ubicacion de estadio no puede ser vacio") String ubicacion) {
		super();
		this.idEstadio = idEstadio;
		this.codigoEstadio = codigoEstadio;
		this.nombreEstadio = nombreEstadio;
		this.capacidad = capacidad;
		this.ubicacion = ubicacion;
	}
	
	
	public EstadioModel(EstadioJPA estadio) {
		this.idEstadio = estadio.getIdEstadio();
		this.codigoEstadio = estadio.getCodigoEstadio();
		this.nombreEstadio = estadio.getNombreEstadio();
		this.capacidad = estadio.getCapacidad();
		this.ubicacion = estadio.getUbicacion();
	}
	@Override
	public String toString() {
		return "EstadioModel [idEstadio=" + idEstadio + ", codigoEstadio=" + codigoEstadio + ", nombreEstadio="
				+ nombreEstadio + ", capacidad=" + capacidad + ", ubicacion=" + ubicacion + "]";
	}
	
}
