package com.api.model.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.api.jpa.entity.FaltasJPA;
import com.api.jpa.entity.JugadorJPA;
import com.api.jpa.entity.PartidoJPA;

public class FaltasModel implements Serializable {
	
	
	private int idFalta;
	
	@NotBlank (message="Tipo de Falta no puede ser vacio")
	private String tipoFalta;
	
	@NotNull  (message="Minuto de falta no puede ser vacio")
	private int minutoFalta;
	
	
	private JugadorJPA jugador;
	
	@NotBlank(message="codigo de jugador no puede ser vacio")
	private String codigoJugador;
	
	
	private PartidoJPA partido;
	
	@NotBlank(message="codigo de Partido no puede ser vacio")
	private String codigoPartido;
	
	


	public int getIdFalta() {
		return idFalta;
	}



	public void setIdFalta(int idFalta) {
		this.idFalta = idFalta;
	}



	public String getTipoFalta() {
		return tipoFalta;
	}



	public void setTipoFalta(String tipoFalta) {
		this.tipoFalta = tipoFalta;
	}



	public int getMinutoFalta() {
		return minutoFalta;
	}



	public void setMinutoFalta(int minutoFalta) {
		this.minutoFalta = minutoFalta;
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



	public FaltasModel() {
		
	}
	

	public FaltasModel(int idFalta, @NotBlank(message = "Tipo de Falta no puede ser vacio") String tipoFalta,
			@NotNull(message = "Minuto de falta no puede ser vacio") int minutoFalta, JugadorJPA jugador,
			@NotBlank(message = "codigo de jugador no puede ser vacio") String codigoJugador, PartidoJPA partido,
			@NotBlank(message = "codigo de Partido no puede ser vacio") String codigoPartido) {
		super();
		this.idFalta = idFalta;
		this.tipoFalta = tipoFalta;
		this.minutoFalta = minutoFalta;
		this.jugador = jugador;
		this.codigoJugador = codigoJugador;
		this.partido = partido;
		this.codigoPartido = codigoPartido;
	}



	public FaltasModel(FaltasJPA falta) {
		this.idFalta = falta.getIdFalta();
		this.tipoFalta = falta.getTipoFalta();
		this.minutoFalta = falta.getMinutoFalta();
		this.jugador = falta.getJugador();
		this.partido = falta.getPartido();
	}


	@Override
	public String toString() {
		return "FaltasModel [idFalta=" + idFalta + ", tipoFalta=" + tipoFalta + ", minutoFalta=" + minutoFalta
				+ ", jugador=" + jugador + ", partido=" + partido + "]";
	}
	
	

}
