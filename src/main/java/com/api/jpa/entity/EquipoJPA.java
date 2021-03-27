package com.api.jpa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.api.model.entity.EquipoModel;

@Entity
@Table (name= "tb_equipo")
public class EquipoJPA implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_equipo")
	private int idEquipo;
	
	@Column (name="nombre_equipo" , nullable=false , length= 200 ,unique= true )
	private String nombreEquipo;
	
	@Column (name="anio_fundacion" , nullable=true )
	@Temporal(TemporalType.DATE)
	private Date anioFundacion;
	
	@Column (name="anios_existencia" , nullable=false , length= 10 )
	private int aniosExistencia;
	
	@Column (name="imagen_escudo" , nullable=false , length= 200 )
	private String imagenEscudo;
	
	@Column (name="duenio_actual" , nullable=false , length= 100 )
	private String duenioActual;
	
	@Column (name="patrocinador_oficial" , nullable=false , length= 100 )
	private String patrocinadorOficial;
	
	public EquipoJPA() {
		
	}


	public EquipoJPA(int idEquipo, String nombreEquipo, Date anioFundacion, int aniosExistencia, String imagenEscudo,
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
	
	public EquipoJPA(EquipoModel equipo) {
		this.idEquipo = equipo.getIdEquipo();
		this.nombreEquipo = equipo.getNombreEquipo();
		this.anioFundacion = equipo.getAnioFundacion();
		this.aniosExistencia = equipo.getAniosExistencia();
		this.imagenEscudo = equipo.getImagenEscudo();
		this.duenioActual = equipo.getDuenioActual();
		this.patrocinadorOficial = equipo.getPatrocinadorOficial();
	}



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



	@Override
	public String toString() {
		return "EquipoJPA [idEquipo=" + idEquipo + ", nombreEquipo=" + nombreEquipo + ", anioFundacion=" + anioFundacion
				+ ", aniosExistencia=" + aniosExistencia + ", imagenEscudo=" + imagenEscudo + ", duenioActual="
				+ duenioActual + ", patrocinadorOficial=" + patrocinadorOficial + "]";
	}



}
