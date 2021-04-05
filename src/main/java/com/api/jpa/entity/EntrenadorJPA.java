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

import com.api.model.entity.EntrenadorModel;
@Entity
@Table(name = "tb_entrenador")
public class EntrenadorJPA implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_entrenador")
	private int idEntrenador;
	
	@Column(name="codigo_entrenador" , nullable=false ,unique= true , length= 10 )
	private String codigoEntrenador;
	
	@Column (name="nombre_entrenador" , nullable=false , length= 50 )
	private String nombreEntrenador;
	
	@Column (name="fecha_nacimiento" , nullable=false)
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	
	@Column (name="nacionalidad" , nullable=false , length= 50 )
	private String nacionalidad;
	
	@Column (name="anios_inicio_laboral" , nullable=false )
	@Temporal(TemporalType.DATE)
	private Date aniosInicioLaboral;
	
	@Column (name="titulos_ganados" , nullable=false , length= 10 )
	private int titulosGanados;
	
	public EntrenadorJPA() {
		
	}


	public EntrenadorJPA(int idEntrenador, String codigoEntrenador, String nombreEntrenador, Date fechaNacimiento,
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


	public EntrenadorJPA( EntrenadorModel entrenador) {
		this.idEntrenador = entrenador.getIdEntrenador();
		this.codigoEntrenador = entrenador.getCodigoEntrenador();
		this.nombreEntrenador = entrenador.getNombreEntrenador();
		this.fechaNacimiento = entrenador.getFechaNacimiento();
		this.nacionalidad = entrenador.getNacionalidad();
		this.aniosInicioLaboral = entrenador.getAniosInicioLaboral();
		this.titulosGanados = entrenador.getTitulosGanados();
	}

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



	@Override
	public String toString() {
		return "EntrenadorJPA [idEntrenador=" + idEntrenador + ", codigoEntrenador=" + codigoEntrenador
				+ ", nombreEntrenador=" + nombreEntrenador + ", fechaNacimiento=" + fechaNacimiento + ", nacionalidad="
				+ nacionalidad + ", aniosInicioLaboral=" + aniosInicioLaboral + ", titulosGanados=" + titulosGanados
				+ "]";
	}



	



}
