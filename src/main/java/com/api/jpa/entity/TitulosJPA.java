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

import com.api.model.entity.TitulosModel;



@Entity
@Table(name = "tb_titulos")
public class TitulosJPA implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_titulo")
	private int idTitulo;
	
	@Column (name="anio_titulo" , nullable=false , length= 100 )
	private String anio_titulo;
	
	@JoinColumn(name="id_equipo", referencedColumnName = "id_equipo")
	@ManyToOne
	private EquipoJPA equipo;
	
	public TitulosJPA() {
		
	}

	public TitulosJPA(int idTitulo, String anio_titulo, EquipoJPA equipo) {
		super();
		this.idTitulo = idTitulo;
		this.anio_titulo = anio_titulo;
		this.equipo = equipo;
	}
	
	public TitulosJPA(TitulosModel titulos) {
		this.idTitulo = titulos.getIdTitulo();
		this.anio_titulo = titulos.getAnio_titulo();
		this.equipo = titulos.getEquipo();
	}

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

	public EquipoJPA getEquipo() {
		return equipo;
	}

	public void setEquipo(EquipoJPA equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return "TitulosJPA [idTitulo=" + idTitulo + ", anio_titulo=" + anio_titulo + ", equipo=" + equipo + "]";
	}
	
}
