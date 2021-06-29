package com.api.model.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.api.jpa.entity.EquipoJPA;

public class EquipoModel implements Serializable {
	
	private int idEquipo;
	
	
	private String codigoEquipo;
	
	@NotBlank(message="Nombre de equipo no puede ser vacio")
	private String nombreEquipo;
	
	@NotNull  (message="fecha de fundación de equipo no puede ser vacio")
	private String anioFundacion;
	
	@NotBlank(message="Imagen escudo de equipo no puede ser vacio")
	private String imagenEscudo;
	
	@NotBlank(message="Dueño de equipo no puede ser vacio")
	private String duenioActual;
	
	@NotNull  (message="cantidad de titulos nacionales de equipo no puede ser vacio")
	private int cantidadTituloNacional;
	
	@NotNull  (message="cantidad de titulos internacionales de equipo no puede ser vacio")
	private int cantidadTituloInternacional;
	
	@NotBlank(message="Patocinador Principal de equipo no puede ser vacio")
	private String patrocinadorPrincipal;
	
	
	
	public int getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	public String getCodigoEquipo() {
		return codigoEquipo;
	}
	public void setCodigoEquipo(String codigoEquipo) {
		this.codigoEquipo = codigoEquipo;
	}
	public String getNombreEquipo() {
		return nombreEquipo;
	}
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public String getAnioFundacion() {
		return anioFundacion;
	}
	public void setAnioFundacion(String anioFundacion) {
		this.anioFundacion = anioFundacion;
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
	public int getCantidadTituloNacional() {
		return cantidadTituloNacional;
	}
	public void setCantidadTituloNacional(int cantidadTituloNacional) {
		this.cantidadTituloNacional = cantidadTituloNacional;
	}
	public int getCantidadTituloInternacional() {
		return cantidadTituloInternacional;
	}
	public void setCantidadTituloInternacional(int cantidadTituloInternacional) {
		this.cantidadTituloInternacional = cantidadTituloInternacional;
	}
	public String getPatrocinadorPrincipal() {
		return patrocinadorPrincipal;
	}
	public void setPatrocinadorPrincipal(String patrocinadorPrincipal) {
		this.patrocinadorPrincipal = patrocinadorPrincipal;
	}
	
	public EquipoModel() {
		
	}

	public EquipoModel(int idEquipo,  String codigoEquipo,
			@NotBlank(message = "Nombre de equipo no puede ser vacio") String nombreEquipo,
			@NotBlank(message = "fecha de fundación de equipo no puede ser vacio") String anioFundacion,
			@NotBlank(message = "Imagen escudo de equipo no puede ser vacio") String imagenEscudo,
			@NotBlank(message = "Dueño de equipo no puede ser vacio") String duenioActual,
			@NotNull(message = "cantidad de titulos nacionales de equipo no puede ser vacio") int cantidadTituloNacional,
			@NotNull(message = "cantidad de titulos internacionales de equipo no puede ser vacio") int cantidadTituloInternacional,
			@NotBlank(message = "Patocinador Principal de equipo no puede ser vacio") String patrocinadorPrincipal) {
		super();
		this.idEquipo = idEquipo;
		this.codigoEquipo = codigoEquipo;
		this.nombreEquipo = nombreEquipo;
		this.anioFundacion = anioFundacion;
		this.imagenEscudo = imagenEscudo;
		this.duenioActual = duenioActual;
		this.cantidadTituloNacional = cantidadTituloNacional;
		this.cantidadTituloInternacional = cantidadTituloInternacional;
		this.patrocinadorPrincipal = patrocinadorPrincipal;
	}
	
	
	public EquipoModel(EquipoJPA equipo) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		this.idEquipo = equipo.getIdEquipo();
		this.codigoEquipo = equipo.getCodigoEquipo();
		this.nombreEquipo = equipo.getNombreEquipo();
		this.anioFundacion = sdf.format(equipo.getAnioFundacion());	
		this.imagenEscudo = equipo.getImagenEscudo();
		this.duenioActual = equipo.getDuenioActual();
		this.cantidadTituloNacional = equipo.getCantidadTituloNacional();
		this.cantidadTituloInternacional = equipo.getCantidadTituloInternacional();
		this.patrocinadorPrincipal = equipo.getPatrocinadorPrincipal();
	}
	
	
	@Override
	public String toString() {
		return "EquipoModel [idEquipo=" + idEquipo + ", codigoEquipo=" + codigoEquipo + ", nombreEquipo=" + nombreEquipo
				+ ", anioFundacion=" + anioFundacion + ", imagenEscudo=" + imagenEscudo + ", duenioActual="
				+ duenioActual + ", cantidadTituloNacional=" + cantidadTituloNacional + ", cantidadTituloInternacional="
				+ cantidadTituloInternacional + ", patrocinadorPrincipal=" + patrocinadorPrincipal + "]";
	}
	
	
	

}
