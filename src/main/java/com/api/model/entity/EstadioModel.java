package com.api.model.entity;

import java.io.Serializable;

import com.api.jpa.entity.EstadioJPA;

public class EstadioModel implements Serializable {
	
	private int idEstadio;
	private String nombreEstadio;
	private int capacidad;
	private String ubicacion;
	public int getIdEstadio() {
		return idEstadio;
	}
	public void setIdEstadio(int idEstadio) {
		this.idEstadio = idEstadio;
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
	public EstadioModel(int idEstadio, String nombreEstadio, int capacidad, String ubicacion) {
		super();
		this.idEstadio = idEstadio;
		this.nombreEstadio = nombreEstadio;
		this.capacidad = capacidad;
		this.ubicacion = ubicacion;
	}
	
	public EstadioModel(EstadioJPA estadio) {
		this.idEstadio = estadio.getIdEstadio();
		this.nombreEstadio = estadio.getNombreEstadio();
		this.capacidad = estadio.getCapacidad();
		this.ubicacion = estadio.getUbicacion();
	}
	
	
	
	@Override
	public String toString() {
		return "EstadioModel [idEstadio=" + idEstadio + ", nombreEstadio=" + nombreEstadio + ", capacidad=" + capacidad
				+ ", ubicacion=" + ubicacion + "]";
	}
	
	

	
}
