package com.api.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.jpa.entity.EntrenadorJPA;
import com.api.jpa.entity.EquipoJPA;
import com.api.jpa.entity.EstadioJPA;
import com.api.jpa.entity.FaltasJPA;
import com.api.jpa.entity.GolesJPA;
import com.api.jpa.entity.JugadorJPA;
import com.api.jpa.entity.PartidoJPA;
import com.api.jpa.entity.PosicionesJPA;
import com.api.jpa.entity.TituloJPA;
import com.api.model.entity.EntrenadorModel;
import com.api.model.entity.EquipoModel;
import com.api.model.entity.EstadioModel;
import com.api.model.entity.FaltasModel;
import com.api.model.entity.GolesModel;
import com.api.model.entity.JugadorModel;
import com.api.model.entity.PartidoModel;
import com.api.model.entity.PosicionesModel;
import com.api.model.entity.TituloModel;

@Component("convertidor")
public class Convertidor {
	
	public List<EntrenadorModel> convertirListaEntrenador (List<EntrenadorJPA> lista){
		List<EntrenadorModel> lstResultEntrenador = new ArrayList<>();
		
		for (EntrenadorJPA entrenador : lista) {
			lstResultEntrenador.add(new EntrenadorModel(entrenador));
		}
		return lstResultEntrenador;
	}
	
	public EntrenadorModel convertirEntrenadorModel (EntrenadorJPA entrenador) {
		return new EntrenadorModel(entrenador);
	}
	
	public EntrenadorJPA convertirEntrenadorJPA (EntrenadorModel entrenador) {
		return new EntrenadorJPA(entrenador);
	}
	
	// -------------------------------------------------------------------------------
	
	public List<EquipoModel> convertirListaEquipo (List<EquipoJPA> lista){
		List<EquipoModel> lstResultEquipo = new ArrayList<>();
		
		for (EquipoJPA equipo : lista) {
			lstResultEquipo.add(new EquipoModel(equipo));
		}
		return lstResultEquipo;
	}
	
	public EquipoModel convertirEquipoModel (EquipoJPA equipo) {
		return new EquipoModel(equipo);
	}
	
	public EquipoJPA convertirEquipoJPA (EquipoModel equipo) {
		return new EquipoJPA(equipo);
	}
	
	// -----------------------------------------------------------------------
	
	public List<EstadioModel> convertirListaEstadio (List<EstadioJPA> lista){
		List<EstadioModel> lstResultEstadio = new ArrayList<>();
		
		for (EstadioJPA estadio : lista) {
			lstResultEstadio.add(new EstadioModel(estadio));
		}
		return lstResultEstadio;
	}
	
	public EstadioModel convertirEstadioModel (EstadioJPA estadio) {
		return new EstadioModel(estadio);
	}
	
	public EstadioJPA convertirEstadioJPA (EstadioModel estadio) {
		return new EstadioJPA(estadio);
	}
	
	// --------------------------------------------------------------------
	
	public List<FaltasModel> convertirListaFaltas (List<FaltasJPA> lista){
		List<FaltasModel> lstResultFaltas = new ArrayList<>();
		
		for (FaltasJPA faltas : lista) {
			lstResultFaltas.add(new FaltasModel(faltas));
		}
		return lstResultFaltas;
	}
	
	public FaltasModel convertirFaltasModel (FaltasJPA faltas) {
		return new FaltasModel(faltas);
	}
	
	public FaltasJPA convertirFaltasJPA (FaltasModel faltas) {
		return new FaltasJPA(faltas);
	}
	
	//--------------------------------------------------------------------
	
	public List<GolesModel> convertirListaGoles (List<GolesJPA> lista){
		List<GolesModel> lstResultGoles = new ArrayList<>();
		
		for (GolesJPA goles : lista) {
			lstResultGoles.add(new GolesModel(goles));
		}
		return lstResultGoles;
	}
	
	public GolesModel convertirGolesModel (GolesJPA goles) {
		return new GolesModel(goles);
	}
	
	public GolesJPA convertirGolesJPA (GolesModel goles) {
		return new GolesJPA(goles);
	}
	
	//-----------------------------------------------------------------------
	
	public List<JugadorModel> convertirListaJugador (List<JugadorJPA> lista){
		List<JugadorModel> lstResultJugador = new ArrayList<>();
		
		for (JugadorJPA jugador : lista) {
			lstResultJugador.add(new JugadorModel(jugador));
		}
		return lstResultJugador;
	}
	
	public JugadorModel convertirJugadorModel (JugadorJPA jugador) {
		return new JugadorModel(jugador);
	}
	
	public JugadorJPA convertirJugadorJPA (JugadorModel jugador) {
		return new JugadorJPA(jugador);
	}
	
	//----------------------------------------------------------------------
	
	public List<PartidoModel> convertirListaPartido (List<PartidoJPA> lista){
		List<PartidoModel> lstResultPartido = new ArrayList<>();
		
		for (PartidoJPA partido : lista) {
			lstResultPartido.add(new PartidoModel(partido));
		}
		return lstResultPartido;
	}
	
	public PartidoModel convertirPartidoModel (PartidoJPA partido) {
		return new PartidoModel(partido);
	}
	
	public PartidoJPA convertirPartidoJPA (PartidoModel partido) {
		return new PartidoJPA(partido);
	}
	
	//-----------------------------------------------------------------------

	public List<PosicionesModel> convertirListaPosiciones (List<PosicionesJPA> lista){
		List<PosicionesModel> lstResultPosiciones = new ArrayList<>();
		
		for (PosicionesJPA posciones : lista) {
			lstResultPosiciones.add(new PosicionesModel(posciones));
		}
		return lstResultPosiciones;
	}
	
	public PosicionesModel convertirPoscionesModel (PosicionesJPA posciones) {
		return new PosicionesModel(posciones);
	}
	
	public PosicionesJPA convertirPoscionesJPA (PosicionesModel posciones) {
		return new PosicionesJPA(posciones);
	}
	
	//----------------------------------------------------------------------
	
	public List<TituloModel> convertirListaTitulos (List<TituloJPA> lista){
		List<TituloModel> lstResultTitulo = new ArrayList<>();
		
		for ( TituloJPA titulos: lista) {
			lstResultTitulo.add(new TituloModel(titulos));
		}
		return lstResultTitulo;
	}
	
	public TituloModel convertirTitulosModel (TituloJPA titulos) {
		return new TituloModel(titulos);
	}
	
	public TituloJPA convertirTitulosJPA (TituloModel titulos) {
		return new TituloJPA(titulos);
	}
	
}
