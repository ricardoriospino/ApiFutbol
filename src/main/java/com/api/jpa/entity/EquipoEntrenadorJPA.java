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

@Entity
@Table (name="tb_rol_menu")
public class EquipoEntrenadorJPA implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_equipo_entrenador")
	private int idEquipoEntrenador;
	
	@JoinColumn(name="id_equipo", referencedColumnName = "id_equipo")
	@ManyToOne
	private EquipoJPA equipo;
	
	@JoinColumn(name="id_entrenador", referencedColumnName = "id_entrenador")
	@ManyToOne
	private EntrenadorJPA entrenador;
	
	public EquipoEntrenadorJPA() {
		
	}

	public EquipoEntrenadorJPA(int idEquipoEntrenador, EquipoJPA equipo, EntrenadorJPA entrenador) {
		super();
		this.idEquipoEntrenador = idEquipoEntrenador;
		this.equipo = equipo;
		this.entrenador = entrenador;
	}
	
	// aqui va EquipoEntrenadorJPA a EquipoEntrenadorModel

	public int getIdEquipoEntrenador() {
		return idEquipoEntrenador;
	}

	public void setIdEquipoEntrenador(int idEquipoEntrenador) {
		this.idEquipoEntrenador = idEquipoEntrenador;
	}

	public EquipoJPA getEquipo() {
		return equipo;
	}

	public void setEquipo(EquipoJPA equipo) {
		this.equipo = equipo;
	}

	public EntrenadorJPA getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(EntrenadorJPA entrenador) {
		this.entrenador = entrenador;
	}

	@Override
	public String toString() {
		return "EquipoEntrenadorJPA [idEquipoEntrenador=" + idEquipoEntrenador + ", equipo=" + equipo + ", entrenador="
				+ entrenador + "]";
	}
	
	

}
