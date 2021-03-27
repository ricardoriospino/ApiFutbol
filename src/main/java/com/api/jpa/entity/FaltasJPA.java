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
	private int idFaltas;
	
	@Column (name="faltas_amarilla", length= 10 )
	private int faltasAmarilla;
	
	@Column (name="faltas_roja", length= 10 )
	private int faltasRojas;
	
	@JoinColumn(name="id_jugador", referencedColumnName = "id_jugador")
	@ManyToOne
	private JugadorJPA jugador;
	
	public FaltasJPA() {
		
	}

	public FaltasJPA(int idFaltas, int faltasAmarilla, int faltasRojas, JugadorJPA jugador) {
		super();
		this.idFaltas = idFaltas;
		this.faltasAmarilla = faltasAmarilla;
		this.faltasRojas = faltasRojas;
		this.jugador = jugador;
	}
	
	public FaltasJPA(FaltasModel faltas) {
		this.idFaltas = faltas.getIdFaltas();
		this.faltasAmarilla = faltas.getFaltasAmarilla();
		this.faltasRojas = faltas.getFaltasRojas();
		this.jugador = faltas.getJugador();
	}

	public int getIdFaltas() {
		return idFaltas;
	}

	public void setIdFaltas(int idFaltas) {
		this.idFaltas = idFaltas;
	}

	public int getFaltasAmarilla() {
		return faltasAmarilla;
	}

	public void setFaltasAmarilla(int faltasAmarilla) {
		this.faltasAmarilla = faltasAmarilla;
	}

	public int getFaltasRojas() {
		return faltasRojas;
	}

	public void setFaltasRojas(int faltasRojas) {
		this.faltasRojas = faltasRojas;
	}

	public JugadorJPA getJugador() {
		return jugador;
	}

	public void setJugador(JugadorJPA jugador) {
		this.jugador = jugador;
	}

	@Override
	public String toString() {
		return "FaltasJPA [idFaltas=" + idFaltas + ", faltasAmarilla=" + faltasAmarilla + ", faltasRojas=" + faltasRojas
				+ ", jugador=" + jugador + "]";
	}
	
	

}
