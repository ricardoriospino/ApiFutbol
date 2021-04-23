package com.api.model.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.api.jpa.entity.FaltaJPA;
import com.api.jpa.entity.JugadorJPA;
import com.api.jpa.entity.PartidoJPA;

public class FaltaModel implements Serializable {
	
	
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
	
	private int idJugador;
	
	private int idPartido;
	

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



	public FaltaModel() {
		
	}
	

	


	public FaltaModel(int idFalta, @NotBlank(message = "Tipo de Falta no puede ser vacio") String tipoFalta,
			@NotNull(message = "Minuto de falta no puede ser vacio") int minutoFalta, JugadorJPA jugador,
			@NotBlank(message = "codigo de jugador no puede ser vacio") String codigoJugador, PartidoJPA partido,
			@NotBlank(message = "codigo de Partido no puede ser vacio") String codigoPartido, int idJugador,
			int idPartido) {
		super();
		this.idFalta = idFalta;
		this.tipoFalta = tipoFalta;
		this.minutoFalta = minutoFalta;
		this.jugador = jugador;
		this.codigoJugador = codigoJugador;
		this.partido = partido;
		this.codigoPartido = codigoPartido;
		this.idJugador = idJugador;
		this.idPartido = idPartido;
	}

	public FaltaModel(FaltaJPA falta) {
		this.idFalta = falta.getIdFalta();
		this.tipoFalta = falta.getTipoFalta();
		this.minutoFalta = falta.getMinutoFalta();
		this.codigoJugador = falta.getJugador().getCodigoJugador();
		this.codigoPartido = falta.getPartido().getCodigoPartido();
		this.idJugador = falta.getJugador().getIdJugador();
		this.idPartido = falta.getPartido().getIdPartido();
	}

	@Override
	public String toString() {
		return "FaltaModel [idFalta=" + idFalta + ", tipoFalta=" + tipoFalta + ", minutoFalta=" + minutoFalta
				+ ", jugador=" + jugador + ", codigoJugador=" + codigoJugador + ", partido=" + partido
				+ ", codigoPartido=" + codigoPartido + ", idJugador=" + idJugador + ", idPartido=" + idPartido + "]";
	}


	

}
