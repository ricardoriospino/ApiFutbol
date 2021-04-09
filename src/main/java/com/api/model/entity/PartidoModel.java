package com.api.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.api.jpa.entity.EquipoJPA;
import com.api.jpa.entity.PartidoJPA;

public class PartidoModel implements Serializable {
	
	private int idPartido;
	
	@NotBlank (message="Codigo de Partido no puede ser vacio")
	private String codigoPartido;
	
	@NotNull (message="fecha de Hora de Partido no puede ser vacio")
	private Date fechaHora;
	
	@NotNull (message="numero Goles de Partido no puede ser vacio")
	private int numeroGoles;
	
	@NotNull (message="numero Faltas de Partido no puede ser vacio")
	private int numeroFaltas;
	
	private int golesEquipo1;
	private int golesEquipo2;
	private int faltasEquipo1;
	private int faltasEquipo2;
	
	@NotBlank (message="Ganador de Partido no puede ser vacio")
	private String ganador;
	
	@NotBlank (message="Perdedor de Partido no puede ser vacio")
	private String perdedor;
	
	@NotBlank (message="Arbitro de Partido no puede ser vacio")
	private String arbitro;
	
	private EquipoJPA equipo1;
	
	@NotBlank (message="Codigo del queipo 1 no puede ser vacio")
	private String codigoEquipo1;
	
	private EquipoJPA equipo2;
	
	@NotBlank (message="Codigo del queipo 2 no puede ser vacio")
	private String codigoEquipo2;
	
	
	public int getIdPartido() {
		return idPartido;
	}
	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}
	public String getCodigoPartido() {
		return codigoPartido;
	}
	public void setCodigoPartido(String codigoPartido) {
		this.codigoPartido = codigoPartido;
	}
	public Date getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
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
	public String getPerdedor() {
		return perdedor;
	}
	public void setPerdedor(String perdedor) {
		this.perdedor = perdedor;
	}
	public String getArbitro() {
		return arbitro;
	}
	public void setArbitro(String arbitro) {
		this.arbitro = arbitro;
	}
	public EquipoJPA getEquipo1() {
		return equipo1;
	}
	public void setEquipo1(EquipoJPA equipo1) {
		this.equipo1 = equipo1;
	}
	public EquipoJPA getEquipo2() {
		return equipo2;
	}
	public void setEquipo2(EquipoJPA equipo2) {
		this.equipo2 = equipo2;
	}
	
	public String getCodigoEquipo1() {
		return codigoEquipo1;
	}
	public void setCodigoEquipo1(String codigoEquipo1) {
		this.codigoEquipo1 = codigoEquipo1;
	}
	public String getCodigoEquipo2() {
		return codigoEquipo2;
	}
	public void setCodigoEquipo2(String codigoEquipo2) {
		this.codigoEquipo2 = codigoEquipo2;
	}
	public PartidoModel() {
		
	}
	

	
	public PartidoModel(int idPartido, @NotBlank(message = "Codigo de Partido no puede ser vacio") String codigoPartido,
			@NotNull(message = "fecha de Hora de Partido no puede ser vacio") Date fechaHora,
			@NotNull(message = "numero Goles de Partido no puede ser vacio") int numeroGoles,
			@NotNull(message = "numero Faltas de Partido no puede ser vacio") int numeroFaltas, int golesEquipo1,
			int golesEquipo2, int faltasEquipo1, int faltasEquipo2,
			@NotBlank(message = "Ganador de Partido no puede ser vacio") String ganador,
			@NotBlank(message = "Perdedor de Partido no puede ser vacio") String perdedor,
			@NotBlank(message = "Arbitro de Partido no puede ser vacio") String arbitro, EquipoJPA equipo1,
			@NotBlank(message = "Codigo del queipo 1 no puede ser vacio") String codigoEquipo1, EquipoJPA equipo2,
			@NotBlank(message = "Codigo del queipo 2 no puede ser vacio") String codigoEquipo2) {
		super();
		this.idPartido = idPartido;
		this.codigoPartido = codigoPartido;
		this.fechaHora = fechaHora;
		this.numeroGoles = numeroGoles;
		this.numeroFaltas = numeroFaltas;
		this.golesEquipo1 = golesEquipo1;
		this.golesEquipo2 = golesEquipo2;
		this.faltasEquipo1 = faltasEquipo1;
		this.faltasEquipo2 = faltasEquipo2;
		this.ganador = ganador;
		this.perdedor = perdedor;
		this.arbitro = arbitro;
		this.equipo1 = equipo1;
		this.codigoEquipo1 = codigoEquipo1;
		this.equipo2 = equipo2;
		this.codigoEquipo2 = codigoEquipo2;
	}
	public PartidoModel (PartidoJPA partido) {
		this.idPartido = partido.getIdPartido();
		this.codigoPartido = partido.getCodigoPartido();
		this.fechaHora = partido.getFechaHora();
		this.numeroGoles = partido.getNumeroGoles();
		this.numeroFaltas = partido.getNumeroFaltas();
		this.golesEquipo1 = partido.getGolesEquipo1();
		this.golesEquipo2 = partido.getGolesEquipo2();
		this.faltasEquipo1 = partido.getFaltasEquipo1();
		this.faltasEquipo2= partido.getFaltasEquipo2();
		this.ganador =partido.getGanador();
		this.perdedor = partido.getPerdedor();
		this.arbitro = partido.getArbitro();
		this.equipo1 = partido.getEquipo1();
		this.equipo2 = partido.getEquipo2();
	}
	
	
	@Override
	public String toString() {
		return "PartidoModel [idPartido=" + idPartido + ", codigoPartido=" + codigoPartido + ", fechaHora=" + fechaHora
				+ ", numeroGoles=" + numeroGoles + ", numeroFaltas=" + numeroFaltas + ", golesEquipo1=" + golesEquipo1
				+ ", golesEquipo2=" + golesEquipo2 + ", faltasEquipo1=" + faltasEquipo1 + ", faltasEquipo2="
				+ faltasEquipo2 + ", ganador=" + ganador + ", perdedor=" + perdedor + ", arbitro=" + arbitro
				+ ", equipo1=" + equipo1 + ", codigoEquipo1=" + codigoEquipo1 + ", equipo2=" + equipo2
				+ ", codigoEquipo2=" + codigoEquipo2 + "]";
	}
	
	
	
	

}
