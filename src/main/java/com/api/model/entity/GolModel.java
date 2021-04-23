package com.api.model.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.api.jpa.entity.GolJPA;
import com.api.jpa.entity.JugadorJPA;
import com.api.jpa.entity.PartidoJPA;

public class GolModel implements Serializable {
	
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
	
	
	private int idJugador;
	
	private int idPartido;
	
	
	
	
	
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
	

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public int getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}

	public GolModel() {
		
	}
	
	public GolModel(int idGol, @NotNull(message = "Minuto de gol no puede ser vacio") int minutoGol,
			@NotBlank(message = "Descripcion de gol no puede ser vacio") String descripcionGol, JugadorJPA jugador,
			@NotBlank(message = "Codigo Jugador no puede ser vacio") String codigoJugador, PartidoJPA partido,
			@NotBlank(message = " Codigo partido no puede ser vacio") String codigoPartido, int idJugador,
			int idPartido) {
		super();
		this.idGol = idGol;
		this.minutoGol = minutoGol;
		this.descripcionGol = descripcionGol;
		this.jugador = jugador;
		this.codigoJugador = codigoJugador;
		this.partido = partido;
		this.codigoPartido = codigoPartido;
		this.idJugador = idJugador;
		this.idPartido = idPartido;
	}

	public GolModel (GolJPA gol) {
		this.idGol = gol.getIdGol();
		this.minutoGol = gol.getMinutoGol();
		this.descripcionGol = gol.getDescripcionGol();
		this.codigoJugador = gol.getJugador().getCodigoJugador();
		this.codigoPartido = gol.getPartido().getCodigoPartido();
		this.idJugador = gol.getJugador().getIdJugador();
		this.idPartido = gol.getPartido().getIdPartido();
	}

	@Override
	public String toString() {
		return "GolModel [idGol=" + idGol + ", minutoGol=" + minutoGol + ", descripcionGol=" + descripcionGol
				+ ", jugador=" + jugador + ", codigoJugador=" + codigoJugador + ", partido=" + partido
				+ ", codigoPartido=" + codigoPartido + ", idJugador=" + idJugador + ", idPartido=" + idPartido + "]";
	}
		

}
