package com.api.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.api.model.entity.EstadioModel;



@Entity
@Table(name = "tb_estadio")
public class EstadioJPA implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_estadio")
	private int idEstadio;
	
	@Column(name="codigo_estadio" , nullable=false ,unique= true , length= 10 )
	private String codigoEstadio;
	
	@Column (name="nombre_estadio" , nullable=false , length= 50 )
	private String nombreEstadio;
	
	@Column (name="capacidad" , nullable=false , length= 50 )
	private int capacidad;
	
	@Column (name="ubicacion" , nullable=false , length= 200 )
	private String ubicacion;
	
	public EstadioJPA () {
		
	}

	
	public EstadioJPA(int idEstadio, String codigoEstadio, String nombreEstadio, int capacidad, String ubicacion) {
		super();
		this.idEstadio = idEstadio;
		this.codigoEstadio = codigoEstadio;
		this.nombreEstadio = nombreEstadio;
		this.capacidad = capacidad;
		this.ubicacion = ubicacion;
	}



	public EstadioJPA(EstadioModel estadio) {
		this.idEstadio = estadio.getIdEstadio();
		this.codigoEstadio = estadio.getCodigoEstadio();
		this.nombreEstadio = estadio.getNombreEstadio();
		this.capacidad = estadio.getCapacidad();
		this.ubicacion = estadio.getUbicacion();
	}


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


	@Override
	public String toString() {
		return "EstadioJPA [idEstadio=" + idEstadio + ", codigoEstadio=" + codigoEstadio + ", nombreEstadio="
				+ nombreEstadio + ", capacidad=" + capacidad + ", ubicacion=" + ubicacion + "]";
	}
	
	
	
}


