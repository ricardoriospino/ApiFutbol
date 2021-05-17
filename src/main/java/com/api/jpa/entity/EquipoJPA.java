package com.api.jpa.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	@Column(name="codigo_equipo" , nullable=false ,unique= true , length= 10 )
	private String codigoEquipo;
	
	@Column (name="nombre_equipo" , nullable=false , length= 200 ,unique= true )
	private String nombreEquipo;
	
	@Column (name="anio_fundacion" , nullable=true )
	@Temporal(TemporalType.DATE)
	private Date anioFundacion;
	
	@Column (name="imagen_escudo" , nullable=false , length= 200 )
	private String imagenEscudo;
	
	@Column (name="duenio_actual" , nullable=false , length= 100 )
	private String duenioActual;
	
	@Column (name="cantidad_titulo_nacional" , nullable=false ,length= 10 )
	private int cantidadTituloNacional;
	
	@Column (name="cantidad_titulo_internacional" , nullable=false ,length= 10 )
	private int cantidadTituloInternacional;
	
	@Column (name="patrocinador_principal" , nullable=false , length= 100 )
	private String patrocinadorPrincipal;
	
	public EquipoJPA() {
		
	}

	
	public EquipoJPA(int idEquipo, String codigoEquipo, String nombreEquipo, Date anioFundacion, String imagenEscudo,
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


	public EquipoJPA(EquipoModel equipo) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		this.idEquipo = equipo.getIdEquipo();
		this.codigoEquipo = equipo.getCodigoEquipo();
		this.nombreEquipo = equipo.getNombreEquipo();
		this.anioFundacion = sdf.parse(equipo.getAnioFundacion());	
		this.imagenEscudo = equipo.getImagenEscudo();
		this.duenioActual = equipo.getDuenioActual();
		this.cantidadTituloNacional = equipo.getCantidadTituloNacional();
		this.cantidadTituloInternacional = equipo.getCantidadTituloInternacional();
		this.patrocinadorPrincipal = equipo.getPatrocinadorPrincipal();
	}


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


	@Override
	public String toString() {
		return "EquipoJPA [idEquipo=" + idEquipo + ", codigoEquipo=" + codigoEquipo + ", nombreEquipo=" + nombreEquipo
				+ ", anioFundacion=" + anioFundacion + ", imagenEscudo=" + imagenEscudo + ", duenioActual="
				+ duenioActual + ", cantidadTituloNacional=" + cantidadTituloNacional + ", cantidadTituloInternacional="
				+ cantidadTituloInternacional + ", patrocinadorPrincipal=" + patrocinadorPrincipal + "]";
	}

}
