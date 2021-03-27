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

import com.api.model.entity.PartidoModel;

@Entity
@Table (name="tb_partido")
public class PartidoJPA implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_partido")
	private int idPartido;
	
	@Column (name="duracion_partido" , nullable=false , length= 20 )
	private String duracionPartido;
	
	@Column (name="numero_goles" , nullable=false , length= 10 )
	private int numeroGoles;
	
	@Column (name="numero_faltas" , nullable=false , length= 10 )
	private int numeroFaltas;
	
	@Column (name="goles_equipo1" , nullable=true , length= 10 )
	private int golesEquipo1;
	
	@Column (name="goles_equipo2" , nullable=true , length= 10 )
	private int golesEquipo2;
	
	@Column (name="faltas_equipo1" , nullable=true , length= 10 )
	private int faltasEquipo1;
	
	@Column (name="faltas_equipo2" , nullable=true , length= 10 )
	private int faltasEquipo2;
	
	@Column (name="ganador" , nullable=true , length= 50 )
	private String ganador;
	
	@Column (name="empate" , nullable=true , length= 50 )
	private String empate;
	
	@Column (name="perdedor" , nullable=true , length= 50 )
	private String perdedor;
	
	@JoinColumn(name="id_equipo", referencedColumnName = "id_equipo")
	@ManyToOne
	private EquipoJPA equipo;
	
	
	@JoinColumn(name="id_equipo2", referencedColumnName = "id_equipo")
	@ManyToOne
	private EquipoJPA equipo2;
	
	public PartidoJPA() {
		
	}

	public PartidoJPA(int idPartido, String duracionPartido, int numeroGoles, int numeroFaltas, int golesEquipo1,
			int golesEquipo2, int faltasEquipo1, int faltasEquipo2, String ganador, String empate, String perdedor,
			EquipoJPA equipo, EquipoJPA equipo2) {
		super();
		this.idPartido = idPartido;
		this.duracionPartido = duracionPartido;
		this.numeroGoles = numeroGoles;
		this.numeroFaltas = numeroFaltas;
		this.golesEquipo1 = golesEquipo1;
		this.golesEquipo2 = golesEquipo2;
		this.faltasEquipo1 = faltasEquipo1;
		this.faltasEquipo2 = faltasEquipo2;
		this.ganador = ganador;
		this.empate = empate;
		this.perdedor = perdedor;
		this.equipo = equipo;
		this.equipo2 = equipo2;
	}
	
	public PartidoJPA (PartidoModel partido) {
		this.idPartido = partido.getIdPartido();
		this.duracionPartido = partido.getDuracionPartido();
		this.numeroGoles = partido.getNumeroGoles();
		this.numeroFaltas = partido.getNumeroFaltas();
		this.golesEquipo1 = partido.getGolesEquipo1();
		this.golesEquipo2 = partido.getGolesEquipo2();
		this.faltasEquipo1 = partido.getFaltasEquipo1();
		this.faltasEquipo2= partido.getFaltasEquipo2();
		this.ganador =partido.getGanador();
		this.empate = partido.getEmpate();
		this.perdedor = partido.getPerdedor();
		this.equipo = partido.getEquipo();
		this.equipo2 = partido.getEquipo2();
	}

	public int getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}

	public String getDuracionPartido() {
		return duracionPartido;
	}

	public void setDuracionPartido(String duracionPartido) {
		this.duracionPartido = duracionPartido;
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

	public int getGolesEquipo1() {
		return golesEquipo1;
	}

	public void setGolesEquipo1(int golesEquipo1) {
		this.golesEquipo1 = golesEquipo1;
	}

	public int getGolesEquipo2() {
		return golesEquipo2;
	}

	public void setGolesEquipo2(int golesEquipo2) {
		this.golesEquipo2 = golesEquipo2;
	}

	public int getFaltasEquipo1() {
		return faltasEquipo1;
	}

	public void setFaltasEquipo1(int faltasEquipo1) {
		this.faltasEquipo1 = faltasEquipo1;
	}

	public int getFaltasEquipo2() {
		return faltasEquipo2;
	}

	public void setFaltasEquipo2(int faltasEquipo2) {
		this.faltasEquipo2 = faltasEquipo2;
	}

	public String getGanador() {
		return ganador;
	}

	public void setGanador(String ganador) {
		this.ganador = ganador;
	}

	public String getEmpate() {
		return empate;
	}

	public void setEmpate(String empate) {
		this.empate = empate;
	}

	public String getPerdedor() {
		return perdedor;
	}

	public void setPerdedor(String perdedor) {
		this.perdedor = perdedor;
	}

	public EquipoJPA getEquipo() {
		return equipo;
	}

	public void setEquipo(EquipoJPA equipo) {
		this.equipo = equipo;
	}

	public EquipoJPA getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(EquipoJPA equipo2) {
		this.equipo2 = equipo2;
	}

	@Override
	public String toString() {
		return "PartidoJPA [idPartido=" + idPartido + ", duracionPartido=" + duracionPartido + ", numeroGoles="
				+ numeroGoles + ", numeroFaltas=" + numeroFaltas + ", golesEquipo1=" + golesEquipo1 + ", golesEquipo2="
				+ golesEquipo2 + ", faltasEquipo1=" + faltasEquipo1 + ", faltasEquipo2=" + faltasEquipo2 + ", ganador="
				+ ganador + ", empate=" + empate + ", perdedor=" + perdedor + ", equipo=" + equipo + ", equipo2="
				+ equipo2 + "]";
	}
	
	

}
