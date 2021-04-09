package com.api.model.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.api.jpa.entity.GolesJPA;
import com.api.jpa.entity.JugadorJPA;
import com.api.jpa.entity.PartidoJPA;

public class GolesModel implements Serializable {
	
	private int idGol;
	
	@NotNull  (message="Minuto de gol no puede ser vacio")
	private int minutoGol;
	
	@NotBlank (message="Descripcion de gol no puede ser vacio")
	private String descripcionGol;
	
	private JugadorJPA jugador;
	
	@NotBlank (message="Codigo Jugador no puede ser vacio")
	private String codigoJugador;
	
	private PartidoJPA partido;
	
	@NotBlank (message=" Codigo partido no puede ser vacio")
	private String codigoPartido;
	
	
	
	
	public int getIdGol() {
		return idGol;
	}


	public void setIdGol(int idGol) {
		this.idGol = idGol;
	}


	public int getMinutoGol() {
		return minutoGol;
	}



	public void setMinutoGol(int minutoGol) {
		this.minutoGol = minutoGol;
	}



	public String getDescripcionGol() {
		return descripcionGol;
	}


	public void setDescripcionGol(String descripcionGol) {
		this.descripcionGol = descripcionGol;
	}


	public JugadorJPA getJugador() {
		return jugador;
	}

	public void setJugador(JugadorJPA jugador) {
		this.jugador = jugador;
	}


	public String getCodigoJugador() {
		return codigoJugador;
	}

	public void setCodigoJugador(String codigoJugador) {
		this.codigoJugador = codigoJugador;
	}


	public PartidoJPA getPartido() {
		return partido;
	}



	public void setPartido(PartidoJPA partido) {
		this.partido = partido;
	}


	public String getCodigoPartido() {
		return codigoPartido;
	}

	public void setCodigoPartido(String codigoPartido) {
		this.codigoPartido = codigoPartido;
	}

	public GolesModel() {
		
	}
	

	public GolesModel(int idGol, @NotNull(message = "Minuto de gol no puede ser vacio") int minutoGol,
			@NotBlank(message = "Descripcion de gol no puede ser vacio") String descripcionGol, JugadorJPA jugador,
			@NotBlank(message = "Codigo Jugador no puede ser vacio") String codigoJugador, PartidoJPA partido,
			@NotBlank(message = " Codigo partido no puede ser vacio") String codigoPartido) {
		super();
		this.idGol = idGol;
		this.minutoGol = minutoGol;
		this.descripcionGol = descripcionGol;
		this.jugador = jugador;
		this.codigoJugador = codigoJugador;
		this.partido = partido;
		this.codigoPartido = codigoPartido;
	}


	public GolesModel (GolesJPA gol) {
		this.idGol = gol.getIdGol();
		this.minutoGol = gol.getMinutoGol();
		this.descripcionGol = gol.getDescripcionGol();
		this.jugador = gol.getJugador();
		this.partido = gol.getPartido();
	}
	
	@Override
	public String toString() {
		return "GolesModel [idGol=" + idGol + ", minutoGol=" + minutoGol + ", descripcionGol=" + descripcionGol
				+ ", jugador=" + jugador + ", partido=" + partido + "]";
	}
	
	
	
	

}
