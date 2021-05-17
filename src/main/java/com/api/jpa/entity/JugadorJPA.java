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

import com.api.model.entity.JugadorModel;

@Entity
@Table(name = "tb_jugador")
public class JugadorJPA implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_jugador")
	private int idJugador;
	
	@Column(name="codigo_jugador" , nullable=false ,unique= true , length= 10 )
	private String codigoJugador;
	
	@Column (name="nombre_jugador" , nullable=false , length= 50 )
	private String nombreJugador;
	
	@Column (name="fecha_nacimiento" , nullable=false)
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@Column (name="anio_de_debut" , nullable=false , length= 10 )
	private int aniosDeDebut;
	
	@Column (name="nacionalidad" , nullable=false , length= 50 )
	private String nacionalidad;
	
	@Column (name="dorsal" , nullable=false , length= 10 )
	private int dorsal;

	@Column (name="posicion" , nullable=false , length= 50 )
	private String posicion;
	
	@Column (name="numero_goles" , nullable=false , length= 10 )
	private int numeroGoles;
	
	@Column (name="numero_faltas" , nullable=false , length= 10 )
	private int numeroFaltas;
	
	public JugadorJPA() {
		
	}

	
	
	public JugadorJPA(int idJugador, String codigoJugador, String nombreJugador, Date fechaNacimiento, int aniosDeDebut,
			String nacionalidad, int dorsal, String posicion, int numeroGoles, int numeroFaltas) {
		super();
		this.idJugador = idJugador;
		this.codigoJugador = codigoJugador;
		this.nombreJugador = nombreJugador;
		this.fechaNacimiento = fechaNacimiento;
		this.aniosDeDebut = aniosDeDebut;
		this.nacionalidad = nacionalidad;
		this.dorsal = dorsal;
		this.posicion = posicion;
		this.numeroGoles = numeroGoles;
		this.numeroFaltas = numeroFaltas;
	}



	public JugadorJPA(JugadorModel jugador) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		this.idJugador = jugador.getIdJugador();
		this.codigoJugador = jugador.getCodigoJugador();
		this.nombreJugador = jugador.getNombreJugador();
		this.fechaNacimiento = sdf.parse(jugador.getFechaNacimiento());
		this.aniosDeDebut = jugador.getAniosDeDebut();
		this.nacionalidad = jugador.getNacionalidad();
		this.dorsal = jugador.getDorsal();
		this.posicion = jugador.getPosicion();
		this.numeroGoles = jugador.getNumeroGoles();
		this.numeroFaltas = jugador.getNumeroFaltas();
	}


	public int getIdJugador() {
		return idJugador;
	}



	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}



	public String getCodigoJugador() {
		return codigoJugador;
	}



	public void setCodigoJugador(String codigoJugador) {
		this.codigoJugador = codigoJugador;
	}



	public String getNombreJugador() {
		return nombreJugador;
	}



	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}



	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	public int getAniosDeDebut() {
		return aniosDeDebut;
	}



	public void setAniosDeDebut(int aniosDeDebut) {
		this.aniosDeDebut = aniosDeDebut;
	}



	public String getNacionalidad() {
		return nacionalidad;
	}



	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}



	public int getDorsal() {
		return dorsal;
	}



	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}



	public String getPosicion() {
		return posicion;
	}



	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}



	public int getNumeroGoles() {
		return numeroGoles;
	}



	public void setNumeroGoles(int numeroGoles) {
		this.numeroGoles = numeroGoles;
	}



	public int getNumeroFaltas() {
		return numeroFaltas;
	}



	public void setNumeroFaltas(int numeroFaltas) {
		this.numeroFaltas = numeroFaltas;
	}



	@Override
	public String toString() {
		return "JugadorJPA [idJugador=" + idJugador + ", codigoJugador=" + codigoJugador + ", nombreJugador="
				+ nombreJugador + ", fechaNacimiento=" + fechaNacimiento + ", aniosDeDebut=" + aniosDeDebut
				+ ", nacionalidad=" + nacionalidad + ", dorsal=" + dorsal + ", posicion=" + posicion + ", numeroGoles="
				+ numeroGoles + ", numeroFaltas=" + numeroFaltas + "]";
	}
	
	
	
}
