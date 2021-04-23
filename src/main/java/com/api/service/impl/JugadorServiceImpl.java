package com.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.jpa.entity.EquipoJPA;
import com.api.jpa.entity.EquipoJugadorJPA;
import com.api.jpa.entity.FaltaJPA;
import com.api.jpa.entity.GolJPA;
import com.api.jpa.entity.JugadorJPA;
import com.api.jpa.entity.PartidoJPA;
import com.api.jpa.repository.EquipoJugadorRepository;
import com.api.jpa.repository.EquipoRepository;
import com.api.jpa.repository.FaltaRepository;
import com.api.jpa.repository.GolRepository;
import com.api.jpa.repository.JugadorRepository;
import com.api.jpa.repository.PartidoRepository;
import com.api.model.entity.EquipoJugadorModel;
import com.api.model.entity.FaltaModel;
import com.api.model.entity.GolModel;
import com.api.model.entity.JugadorModel;
import com.api.rest.dto.JugadorFullDTO;
import com.api.rest.dto.JugadorGolFaltaFullDTO;
import com.api.rest.dto.JugadorGolFullDTO;
import com.api.service.JugadorService;
import com.api.util.Convertidor;

@Service("jugadorServiceImpl")
public class JugadorServiceImpl implements JugadorService {
	private static final Logger log = LogManager.getLogger(JugadorServiceImpl.class);
	
	@Autowired
	@Qualifier("repositorioEquipoJugador")
	private EquipoJugadorRepository repositorioEquipoJugador;
	
	@Autowired
	@Qualifier("repositorioequipo")
	private EquipoRepository repositorioEquipo;
	
	@Autowired
	@Qualifier("repositoriojugador")
	private JugadorRepository repositorio;
	
	@Autowired
	@Qualifier("repositorioFalta")
	private FaltaRepository repositorioFalta;
	
	@Autowired
	@Qualifier("repositorioGol")
	private GolRepository repositorioGol;
	
	
	@Autowired
	@Qualifier("repositorioPartido")
	private PartidoRepository repositorioPartido;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;

	@Override
	public boolean insertar(JugadorModel jugador) {
		
		try {
			
			JugadorJPA jugadorJPA = repositorio.findByCodigoJugador(jugador.getCodigoJugador());

			if(jugadorJPA != null) {
				log.error("Codigo Ya existe");
				return false;
			}
					
			repositorio.save(new JugadorJPA (jugador));
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al insertar " + e);
			return false;
		}
	}
	
	@Override
	public boolean insertarJugadorEquipo(EquipoJugadorModel jugadorEquipo) {
		
		try {
			EquipoJPA equipoJPA = repositorioEquipo.findByCodigoEquipo(jugadorEquipo.getCodigoEquipo());
			
			JugadorJPA jugadorJPA = repositorio.findByCodigoJugador(jugadorEquipo.getCodigoJugador());
			
			if(jugadorJPA == null ) {
				log.error("Jugador no existe");
				return false;
			}
			
			if(equipoJPA == null ) {
				log.error("Equipo no existe");
				return false;
			}
			
			
			EquipoJugadorJPA ej = new  EquipoJugadorJPA( equipoJPA, jugadorJPA, jugadorEquipo.getAnio());
			
			repositorioEquipoJugador.save(ej);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al insertar " + e);
			return false;
		}
	}
	
	@Override
	public boolean insertarFaltaJugadorPartido(FaltaModel falta) {
		
		
		try {
			
			JugadorJPA jugadorJPA = repositorio.findByCodigoJugador(falta.getCodigoJugador());
			
			PartidoJPA partidoJPA = repositorioPartido.findByCodigoPartido(falta.getCodigoPartido());
			
			if(jugadorJPA == null ) {
				log.error("Jugador no existe");
				return false;
			}
			
			if(partidoJPA == null ) {
				log.error("Partido no existe");
				return false;
			}	
			
			FaltaJPA f = new FaltaJPA(falta.getTipoFalta(), falta.getMinutoFalta(), jugadorJPA, partidoJPA);
			
			repositorioFalta.save(f);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al insertarFaltaJugadorPartido " + e);
			return false;
		}
	}
	
	@Override
	public boolean insertarGolJugadorPartido(GolModel gol) {

		try {
			
			JugadorJPA jugadorJPA = repositorio.findByCodigoJugador(gol.getCodigoJugador());
			
			PartidoJPA partidoJPA = repositorioPartido.findByCodigoPartido(gol.getCodigoPartido());
			
			if(jugadorJPA == null ) {
				log.error("Jugador no existe");
				return false;
			}
			
			if(partidoJPA == null ) {
				log.error("Partido no existe");
				return false;
			}
			
			GolJPA g = new GolJPA(gol.getMinutoGol(), gol.getDescripcionGol(), jugadorJPA, partidoJPA);
			
			repositorioGol.save(g);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al insertarGolJugadorPartido " + e);
			return false;
		}
	}

	@Override
	public boolean actualizar(JugadorModel jugador) {
		
		try {
			repositorio.save(new JugadorJPA (jugador));
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al actualizar " + e);
			return false;
		}
	}

	@Override
	public boolean borrar(int id) {
		
		try {
			log.info("Borrar");
			Optional<JugadorJPA> jugador = repositorio.findById(id);
			
			if(jugador.isPresent()) {
				repositorio.delete(jugador.get());
				
			}else {
				log.error("No existe data para ese Id");
				return false;
			}
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al borrar " + e);
			return false;
		}
	}

	@Override
	public List<JugadorModel> obtenerJugadores() {
		
		return convertidor.convertirListaJugador(repositorio.findAll());
	}

	@Override
	public JugadorModel obtenerJugadorPorDorsalyNacionalidad(int dorsal, String nacionalidad) {
		
		return convertidor.convertirJugadorModel(repositorio.findByDorsalAndNacionalidad(dorsal, nacionalidad));
	}

	@Override
	public List<JugadorModel> obtenerJugadoresPaginacion(Pageable paginacion) {
		
		return  convertidor.convertirListaJugador(repositorio.findAll(paginacion).getContent()) ;
	}

	@Override
	public JugadorModel obtenerJugadorPorCodigo(String codigo) {
		
		return convertidor.convertirJugadorModel(repositorio.findByCodigoJugador(codigo));
	}

	@Override
	public JugadorFullDTO obtenerJugadorFporCodigo(String codigo) {
		
		JugadorModel jugador = obtenerJugadorPorCodigo(codigo);
		
		List<EquipoJugadorModel> equipoJugador = convertidor.convertirListaEquiposJugadore
				(repositorioEquipoJugador.findByJugador(new JugadorJPA(jugador)));
		
		return new JugadorFullDTO(jugador , equipoJugador) ;
	}

	@Override
	public JugadorModel obtenerJugadorPorNombre(String nombre) {
		
		return convertidor.convertirJugadorModel(repositorio.findByNombreJugador(nombre));
	}

	@Override
	public JugadorFullDTO obtenerJugadorFporNombre(String nombre) {
		
		JugadorModel jugador = obtenerJugadorPorNombre(nombre);
			
		List<FaltaModel> falta = convertidor.convertirListaFalta(repositorioFalta.findByJugador(new JugadorJPA(jugador)));

		return new JugadorFullDTO(falta, jugador);
	}

	@Override
	public JugadorGolFullDTO obtenerJugadorFporNombreGol(String nombre) {
		
		JugadorModel jugador = obtenerJugadorPorNombre(nombre);
		
		List<GolModel> gol = convertidor.convertirListaGol(repositorioGol.findByJugador(new JugadorJPA(jugador)));
		
		return new JugadorGolFullDTO(jugador, gol);
	}

	@Override
	public JugadorGolFaltaFullDTO obtenerJugadorFullGolyFaltaPorNombre(String nombre) {
		
		JugadorModel jugador = obtenerJugadorPorNombre(nombre);
		
		List<GolModel> gol = convertidor.convertirListaGol(repositorioGol.findByJugador(new JugadorJPA(jugador)));
		
		List<FaltaModel> falta = convertidor.convertirListaFalta(repositorioFalta.findByJugador(new JugadorJPA(jugador)));
		
		return new JugadorGolFaltaFullDTO(jugador, gol, falta);
	}

	


}
