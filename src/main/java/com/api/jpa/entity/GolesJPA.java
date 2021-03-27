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
	
	@Column (name="total_goles" , nullable=false , length= 10 )
	private int totalGoles;
	
	@JoinColumn(name="id_jugador", referencedColumnName = "id_jugador")
	@ManyToOne
	private JugadorJPA jugador;

	public GolesJPA() {
		
	}

	public GolesJPA(int idGoles, int totalGoles, JugadorJPA jugador) {
		super();
		this.idGoles = idGoles;
		this.totalGoles = totalGoles;
		this.jugador = jugador;
	}
	
	public GolesJPA(GolesModel goles) {
		this.idGoles = goles.getIdGoles();
		this.totalGoles = goles.getTotalGoles();
		this.jugador = goles.getJugador();
	}

	public int getIdGoles() {
		return idGoles;
	}

	public void setIdGoles(int idGoles) {
		this.idGoles = idGoles;
	}

	public int getTotalGoles() {
		return totalGoles;
	}

	public void setTotalGoles(int totalGoles) {
		this.totalGoles = totalGoles;
	}

	public JugadorJPA getJugador() {
		return jugador;
	}

	public void setJugador(JugadorJPA jugador) {
		this.jugador = jugador;
	}

	@Override
	public String toString() {
		return "GolesJPA [idGoles=" + idGoles + ", totalGoles=" + totalGoles + ", jugador=" + jugador + "]";
	}
	
	
}
