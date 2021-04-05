package com.api.model.entity;

import java.io.Serializable;
import java.util.Date;

import com.api.jpa.entity.EquipoJPA;

public class EquipoModel implements Serializable {
	
	private int idEquipo;
	private String codigoEquipo;
	private String nombreEquipo;
	private Date anioFundacion;
	private String imagenEscudo;
	private String duenioActual;
	private int cantidadTituloNacional;
	private int cantidadTituloInternacional;
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
	public Date getAnioFundacion() {
		return anioFundacion;
	}
	public void setAnioFundacion(Date anioFundacion) {
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

	public EquipoModel(int idEquipo, String codigoEquipo, String nombreEquipo, Date anioFundacion, String imagenEscudo,
			String duenioActual, int cantidadTituloNacional, int cantidadTituloInternacional,
			String patrocinadorPrincipal) {
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
		this.idEquipo = equipo.getIdEquipo();
		this.codigoEquipo = equipo.getCodigoEquipo();
		this.nombreEquipo = equipo.getNombreEquipo();
		this.anioFundacion = equipo.getAnioFundacion();	
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
