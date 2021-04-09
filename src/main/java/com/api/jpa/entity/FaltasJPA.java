package com.api.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.api.model.entity.FaltasModel;


@Entity
@Table(name = "tb_faltas")
public class FaltasJPA implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_faltas")
	private int idFalta;
	
	@Column (name="tipo_falta",nullable=false , length= 50 )
	private String tipoFalta;
	
	@Column (name="minuto_falta", nullable=false ,  length= 10 )
	private int minutoFalta;
	
	@JoinColumn(name="id_jugador", referencedColumnName = "id_jugador")
	@ManyToOne
	private JugadorJPA jugador;
	
	@JoinColumn(name="id_partido", referencedColumnName = "id_partido")
	@ManyToOne
	private PartidoJPA partido;
	
	
	public FaltasJPA() {
		
	}


	public FaltasJPA(int idFalta, String tipoFalta, int minutoFalta, JugadorJPA jugador, PartidoJPA partido) {
		super();
		this.idFalta = idFalta;
		this.tipoFalta = tipoFalta;
		this.minutoFalta = minutoFalta;
		this.jugador = jugador;
		this.partido = partido;
	}


	public FaltasJPA(FaltasModel falta) {
		this.idFalta = falta.getIdFalta();
		this.tipoFalta = falta.getTipoFalta();
		this.minutoFalta = falta.getMinutoFalta();
		this.jugador = falta.getJugador();
		this.partido = falta.getPartido();
	}

	


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

	public PartidoJPA getPartido() {
		return partido;
	}

	public void setPartido(PartidoJPA partido) {
		this.partido = partido;
	}

	@Override
	public String toString() {
		return "FaltasJPA [idFalta=" + idFalta + ", tipoFalta=" + tipoFalta + ", minutoFalta=" + minutoFalta
				+ ", jugador=" + jugador + ", partido=" + partido + "]";
	}


}
