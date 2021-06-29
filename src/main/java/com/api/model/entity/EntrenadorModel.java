package com.api.model.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.api.jpa.entity.EntrenadorJPA;

public class EntrenadorModel implements Serializable {
	
	private int idEntrenador;
	
	private String codigoEntrenador;
	
	@NotBlank (message="nombre de entrenador no puede ser vacio")
	private String nombreEntrenador;
	
	@NotBlank  (message="fecha de nacimiento de entrenador no puede ser vacio")
	private String fechaNacimiento;
	
	@NotBlank (message="nacionalidad de entrenador no puede ser vacio")
	private String nacionalidad;
	
	@NotBlank  (message=" Año de inicio laboral de entrenador no puede ser vacio")
	private String aniosInicioLaboral;
	
	@NotNull (message=" Titulos ganados de entrenador no puede ser vacio")
	private int titulosGanados;

	
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

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getAniosInicioLaboral() {
		return aniosInicioLaboral;
	}

	public void setAniosInicioLaboral(String aniosInicioLaboral) {
		this.aniosInicioLaboral = aniosInicioLaboral;
	}

	public int getTitulosGanados() {
		return titulosGanados;
	}

	public void setTitulosGanados(int titulosGanados) {
		this.titulosGanados = titulosGanados;
	}
	
	

	public EntrenadorModel(int idEntrenador,
			 String codigoEntrenador,
			@NotBlank(message = "nombre de entrenador no puede ser vacio") String nombreEntrenador,
			@NotBlank(message = "fecha de nacimiento de entrenador no puede ser vacio") String fechaNacimiento,
			@NotBlank(message = "nacionalidad de entrenador no puede ser vacio") String nacionalidad,
			@NotBlank(message = " Año de inicio laboral de entrenador no puede ser vacio") String aniosInicioLaboral,
			@NotNull(message = " Titulos ganados de entrenador no puede ser vacio") int titulosGanados) {
		super();
		this.idEntrenador = idEntrenador;
		this.codigoEntrenador = codigoEntrenador;
		this.nombreEntrenador = nombreEntrenador;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.aniosInicioLaboral = aniosInicioLaboral;
		this.titulosGanados = titulosGanados;
	}
	
	

	// para convertir de un objeto a otro
	public EntrenadorModel(EntrenadorJPA entrenador) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		this.idEntrenador = entrenador.getIdEntrenador();
		this.codigoEntrenador = entrenador.getCodigoEntrenador();
		this.nombreEntrenador = entrenador.getNombreEntrenador();
		this.fechaNacimiento = sdf.format(entrenador.getFechaNacimiento());
		this.nacionalidad = entrenador.getNacionalidad();
		this.aniosInicioLaboral = sdf.format(entrenador.getAniosInicioLaboral());
		this.titulosGanados = entrenador.getTitulosGanados();
	}

	@Override
	public String toString() {
		return "EntrenadorModel [idEntrenador=" + idEntrenador + ", codigoEntrenador=" + codigoEntrenador
				+ ", nombreEntrenador=" + nombreEntrenador + ", fechaNacimiento=" + fechaNacimiento + ", nacionalidad="
				+ nacionalidad + ", aniosInicioLaboral=" + aniosInicioLaboral + ", titulosGanados=" + titulosGanados
				+ "]";
	}

	public String toStringVacio() {
		return "No devuelve datos de Entrenador ";
	}
	
	
}
