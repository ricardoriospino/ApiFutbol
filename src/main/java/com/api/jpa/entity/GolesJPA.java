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

import com.api.model.entity.GolesModel;

@Entity
@Table(name = "tb_goles")
public class GolesJPA implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_goles")
	private int idGoles;
	
	@Column (name="minuto_gol" , nullable=false , length= 10 )
	private int minutoGol;
	
	@Column (name="descripcion_gol" , nullable=false , length= 250 )
	private String descripcionGol;
	
	@JoinColumn(name="id_jugador", referencedColumnName = "id_jugador")
	@ManyToOne
	private JugadorJPA jugador;
	
	@JoinColumn(name="id_partido", referencedColumnName = "id_partido")
	@ManyToOne
	private PartidoJPA partido;

	public GolesJPA() {
		
	}

	
	public GolesJPA(int idGoles, int minutoGol, String descripcionGol, JugadorJPA jugador, PartidoJPA partido) {
		super();
		this.idGoles = idGoles;
		this.minutoGol = minutoGol;
		this.descripcionGol = descripcionGol;
		this.jugador = jugador;
		this.partido = partido;
	}



	public GolesJPA(GolesModel goles) {
		this.idGoles = goles.getIdGoles();
		this.minutoGol = goles.getMinutoGol();
		this.descripcionGol = goles.getDescripcionGol();
		this.jugador = goles.getJugador();
		this.partido = goles.getPartido();
	}


	public int getIdGoles() {
		return idGoles;
	}



	public void setIdGoles(int idGoles) {
		this.idGoles = idGoles;
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



	public PartidoJPA getPartido() {
		return partido;
	}



	public void setPartido(PartidoJPA partido) {
		this.partido = partido;
	}



	@Override
	public String toString() {
		return "GolesJPA [idGoles=" + idGoles + ", minutoGol=" + minutoGol + ", descripcionGol=" + descripcionGol
				+ ", jugador=" + jugador + ", partido=" + partido + "]";
	}

	
}
