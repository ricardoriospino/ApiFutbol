package com.api.util;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.jpa.entity.EntrenadorJPA;
import com.api.jpa.entity.EquipoEntrenadorJPA;
import com.api.jpa.entity.EquipoEstadioJPA;
import com.api.jpa.entity.EquipoJPA;
import com.api.jpa.entity.EquipoJugadorJPA;
import com.api.jpa.entity.EstadioJPA;
import com.api.jpa.entity.FaltaJPA;
import com.api.jpa.entity.GolJPA;
import com.api.jpa.entity.JugadorJPA;
import com.api.jpa.entity.PartidoJPA;
import com.api.jpa.entity.PosicionesJPA;
import com.api.jpa.entity.TituloJPA;
import com.api.jpa.entity.UsuarioJPA;
import com.api.model.entity.EntrenadorModel;
import com.api.model.entity.EquipoEntrenadorModel;
import com.api.model.entity.EquipoEstadioModel;
import com.api.model.entity.EquipoJugadorModel;
import com.api.model.entity.EquipoModel;
import com.api.model.entity.EstadioModel;
import com.api.model.entity.FaltaModel;
import com.api.model.entity.GolModel;
import com.api.model.entity.JugadorModel;
import com.api.model.entity.PartidoModel;
import com.api.model.entity.PosicionesModel;
import com.api.model.entity.TituloModel;
import com.api.model.entity.UsuarioModel;

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
	
	public EntrenadorJPA convertirEntrenadorJPA (EntrenadorModel entrenador) throws ParseException {
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
	
	public List<EquipoJPA> convertirEquipoJPA (List<EquipoModel> equipo) throws ParseException {
		List<EquipoJPA> lstResultEquipos = new ArrayList<>();
		
		for (EquipoModel equipos : equipo) {
			lstResultEquipos.add(new EquipoJPA(equipos));
			
		}
		
		return lstResultEquipos;
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
	
	public List<FaltaModel> convertirListaFaltas (List<FaltaJPA> lista){
		List<FaltaModel> lstResultFaltas = new ArrayList<>();
		
		for (FaltaJPA faltas : lista) {
			lstResultFaltas.add(new FaltaModel(faltas));
		}
		return lstResultFaltas;
	}
	
	public FaltaModel convertirFaltasModel (FaltaJPA faltas) {
		return new FaltaModel(faltas);
	}
	
	public FaltaJPA convertirFaltasJPA (FaltaModel faltas) {
		return new FaltaJPA(faltas);
	}
	
	//--------------------------------------------------------------------
	
	public List<GolModel> convertirListaGoles (List<GolJPA> lista){
		List<GolModel> lstResultGoles = new ArrayList<>();
		
		for (GolJPA goles : lista) {
			lstResultGoles.add(new GolModel(goles));
		}
		return lstResultGoles;
	}
	
	public GolModel convertirGolesModel (GolJPA goles) {
		return new GolModel(goles);
	}
	
	public GolJPA convertirGolesJPA (GolModel goles) {
		return new GolJPA(goles);
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
	
	public JugadorJPA convertirJugadorJPA (JugadorModel jugador) throws ParseException {
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
	
	// --------------------------------------------------------------------------
	
	public List<EquipoEntrenadorModel> convertirListaEquiposEntrenador (List<EquipoEntrenadorJPA> lista){
		List<EquipoEntrenadorModel> lstResultEquipoEntrenador = new ArrayList<>();
		
		for(EquipoEntrenadorJPA equipoEntrenador : lista) {
			lstResultEquipoEntrenador.add(new EquipoEntrenadorModel(equipoEntrenador));
		}
		
		return lstResultEquipoEntrenador;
	}
	
	public EquipoEntrenadorModel converEquipoEntrenadorModel (EquipoEntrenadorJPA equipoEntrenador) {
		return new EquipoEntrenadorModel(equipoEntrenador);
	}
	
	public EquipoEntrenadorJPA convertirEquipoEntrenadorJPA (EquipoEntrenadorModel equipoEntrenador) {
		return new EquipoEntrenadorJPA(equipoEntrenador);
	}
	
	// ------------------------------------------------------------------------
	public List<EquipoJugadorModel> convertirListaEquiposJugadore (List<EquipoJugadorJPA> lista){
		List<EquipoJugadorModel>  lstResultEquipoJugador = new ArrayList<>();
		
		for (EquipoJugadorJPA equipoJugador : lista) {
			lstResultEquipoJugador.add(new EquipoJugadorModel(equipoJugador));
		}
		
		return lstResultEquipoJugador;
	}
	
	public EquipoJugadorModel converEquipoJugadorModel (EquipoJugadorJPA equipoJugador) {
		return new EquipoJugadorModel(equipoJugador);
	}
	
	public EquipoJugadorJPA convertirEquipoJugadorJPA (EquipoJugadorModel equipoJugador) {
		return new EquipoJugadorJPA(equipoJugador);
	}
	
	// ---------------------------------------------------------------------
	public List<EquipoEstadioModel> convertirListaEquipoEstadios (List<EquipoEstadioJPA> lista){
		List<EquipoEstadioModel> lstResultEquipoEstadio = new ArrayList<>();
		
		for (EquipoEstadioJPA equipoEstadio : lista) {
			lstResultEquipoEstadio.add(new EquipoEstadioModel(equipoEstadio));
		}
		
		return lstResultEquipoEstadio;
	}
	
	public EquipoEstadioModel convertirListaEquipoEstadioModel (EquipoEstadioJPA equipoEstadio) {
		return new EquipoEstadioModel(equipoEstadio);
		
	}
	
	public EquipoEstadioJPA convertirListaEquipoEstadioJPA (EquipoEstadioModel equipoEstadio) {
		return new EquipoEstadioJPA(equipoEstadio);
	}
	// ------------------------------------------------------------------------
	
	public List<FaltaModel> convertirListaFalta (List<FaltaJPA> lista){
		List<FaltaModel> lstResultFalta = new ArrayList<>();
		
		for (FaltaJPA falta : lista) {
			lstResultFalta.add(new FaltaModel(falta));
		}
		
		return lstResultFalta;
	}
	
	public FaltaModel convertirListaFaltaModel (FaltaJPA falta) {
		return new FaltaModel(falta);
	}
	
	public FaltaJPA convertirListaFaltaJPA (FaltaModel falta) {
		return new FaltaJPA(falta);
	}
	
	// ---------------------------------------------------------------------------
	public List<GolModel> convertirListaGol (List<GolJPA> lista){
		List<GolModel> lstResultGol = new ArrayList<>();
		
		for (GolJPA gol : lista) {
			lstResultGol.add(new GolModel(gol));
		}
		return lstResultGol;
	}
	
	public GolModel convertirListaGolModel (GolJPA gol) {
		return new GolModel(gol);
	}
	
	public GolJPA convertirListaGolJPA (GolModel gol) {
		return new GolJPA();
	}
	
	//----------------------------------------------------------------------
	
	public List<TituloModel> convertirListaTitulos (List<TituloJPA> lista){
		List<TituloModel> lstResultTitulo = new ArrayList<>();
				
		for ( TituloJPA titulo: lista) {
			lstResultTitulo.add(new TituloModel(titulo));
		}
		return lstResultTitulo;
	}
			
	public TituloModel convertirTitulosModel (TituloJPA titulo) {
		return new TituloModel(titulo);
	}
			
	public TituloJPA convertirTitulosJPA (TituloModel titulo) {
		return new TituloJPA(titulo);
	}
	
	// ------------------------------------------------------------------
	
	public List<UsuarioModel> convertirListaUsuarios (List<UsuarioJPA> lista){
		List<UsuarioModel> lstResltUsuario = new ArrayList<>();
		
		for (UsuarioJPA usuario: lista) {
			lstResltUsuario.add(new UsuarioModel(usuario));
		}
		
		return lstResltUsuario;
	}
	
	public UsuarioModel convertirUsuarioModel (UsuarioJPA usuario) {
		return new UsuarioModel(usuario);

	}
	
	public UsuarioJPA convertirUsuarioJPA (UsuarioModel usuario) {
		return new UsuarioJPA(usuario);
	}
	
	
}
