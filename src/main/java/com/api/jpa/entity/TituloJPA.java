package com.api.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.api.model.entity.TituloModel;


@Entity
@Table(name = "tb_titulos")
public class TituloJPA implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_titulo")
	private int idTitulo;
	
	@Column (name="anio_titulo" , nullable=false , length= 100 )
	private String anioTitulo;
	
	@Column (name="nombre_titulo" , nullable=false , length= 100 )
	private String nombreTitulo;
	
	@Column (name="tipo_titulo"  , nullable=false)
	private boolean tipoTitulo;
	
	@JoinColumn(name="id_equipo", referencedColumnName = "id_equipo")
	@ManyToOne
	private EquipoJPA equipo;
	
	public TituloJPA() {
		
	}

	
	public TituloJPA(int idTitulo, String anioTitulo, String nombreTitulo, boolean tipoTitulo, EquipoJPA equipo) {
		super();
		this.idTitulo = idTitulo;
		this.anioTitulo = anioTitulo;
		this.nombreTitulo = nombreTitulo;
		this.tipoTitulo = tipoTitulo;
		this.equipo = equipo;
	}


	public TituloJPA(TituloModel titulo) {
		this.idTitulo = titulo.getIdTitulo();
		this.anioTitulo = titulo.getAnioTitulo();
		this.nombreTitulo = titulo.getNombreTitulo();
		this.tipoTitulo = titulo.isNacional();
		this.equipo = titulo.getEquipo();
	}


	public int getIdTitulo() {
		return idTitulo;
	}


	public void setIdTitulo(int idTitulo) {
		this.idTitulo = idTitulo;
	}



	public String getAnioTitulo() {
		return anioTitulo;
	}


	public void setAnioTitulo(String anioTitulo) {
		this.anioTitulo = anioTitulo;
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


	@Override
	public String toString() {
		return "TitulosJPA [idTitulo=" + idTitulo + ", anioTitulo=" + anioTitulo + ", nombreTitulo=" + nombreTitulo
				+ ", tipoTitulo=" + tipoTitulo + ", equipo=" + equipo + "]";
	}


	

	
}
