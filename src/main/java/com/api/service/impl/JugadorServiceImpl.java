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
import com.api.jpa.entity.UsuarioJPA;
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
import com.api.model.entity.ResponseErrorModel;
import com.api.rest.dto.JugadorFullDTO;
import com.api.rest.dto.JugadorGolFaltaFullDTO;
import com.api.rest.dto.JugadorGolFullDTO;
import com.api.service.JugadorService;
import com.api.util.ConstanteAPI;
import com.api.util.Convertidor;
import com.api.util.MensajeError;

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
			
			JugadorJPA ultimoJugadorCodigo = repositorio.findTopByOrderByIdJugadorDesc();
			
			String codigo = ultimoJugadorCodigo.getCodigoJugador();
			
			String [] partes = codigo.split("U");
			
			String parte1 = partes[0];
			String parte2 = partes[1];
			
			int codigoNumero = Integer.parseInt(parte2);
			
			codigoNumero++;
			
			String codigoNuevo = generarCodigoJugador(codigoNumero);
			
			jugador.setCodigoJugador(codigoNuevo);
					
			repositorio.save(new JugadorJPA (jugador));
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al insertar " + e);
			return false;
		}
	}
	
	private String generarCodigoJugador(int codigoNumero) {
		
		String longitudNumero = String.valueOf(codigoNumero);
		
		String codigoNuevo ="";
		
		if ( 1 > longitudNumero.length()) {			
			 codigoNuevo = ConstanteAPI.JUGADOR + "00000" + codigoNumero;	
		}else if(2 > longitudNumero.length()) {
			 codigoNuevo = ConstanteAPI.JUGADOR + "0000" + codigoNumero;
		}else if(3 > longitudNumero.length()) {
			codigoNuevo = ConstanteAPI.JUGADOR + "000" + codigoNumero;
		}else if(4 >  longitudNumero.length()) {
			codigoNuevo = ConstanteAPI.JUGADOR + "00" + codigoNumero;
		}else if(5 >  longitudNumero.length()) {
			codigoNuevo = ConstanteAPI.JUGADOR + "0" +  codigoNumero;
		}else {
			codigoNuevo = ConstanteAPI.JUGADOR + codigoNumero;
		}
		
		return codigoNuevo;
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
			
			JugadorJPA jugadorJPA = repositorio.findByIdJugador(jugador.getIdJugador());
			
			if(jugadorJPA == null) {
				log.error("Jugador no existe");
				return false;
			}
						
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
	public Object obtenerJugadorPorDorsalyNacionalidad(int dorsal, String nacionalidad) {
		
		JugadorJPA jugadorJPA = repositorio.findByDorsalAndNacionalidad(dorsal, nacionalidad);
		
		if (jugadorJPA == null) {
					
			log.debug("No encontro datos jugador por parametros por dorsal: "+ dorsal + ", nacionalidad: " + nacionalidad );
			
			return new ResponseErrorModel(MensajeError.COD_OOO8, MensajeError.Mensaje_OOO8);
			
		}else {
			
			JugadorModel jugador = convertidor.convertirJugadorModel(jugadorJPA);
			
			return jugador;
			
		}

	}

	@Override
	public List<JugadorModel> obtenerJugadoresPaginacion(Pageable paginacion) {
		
		
		return  convertidor.convertirListaJugador(repositorio.findAll(paginacion).getContent()) ;
	}

	@Override
	public Object obtenerJugadorPorCodigo(String codigo) {
		
		JugadorJPA jugadorJPA = repositorio.findByCodigoJugador(codigo);
		
		if (jugadorJPA == null) {
			
			
			log.debug("No encontro datos jugador por parametro  codigo: "+ codigo );
			
			return new ResponseErrorModel(MensajeError.COD_OOO8, MensajeError.Mensaje_OOO8);
			
		}else {
			
			JugadorModel jugador = convertidor.convertirJugadorModel(jugadorJPA);
			
			return jugador;
			
		}

	}

	@Override
	public Object obtenerJugadorFporCodigo(String codigo) {
		
		JugadorJPA jugadorJPA = repositorio.findByCodigoJugador(codigo);
		
		
		if(jugadorJPA == null) {
			
			log.debug("No encontro datos jugador por parametro  codigo: "+ codigo );
			
			return new ResponseErrorModel(MensajeError.COD_OOO9, MensajeError.Mensaje_OOO9);
		}else {
			
			JugadorModel jugadorModel = new JugadorModel(jugadorJPA);
			
			List<EquipoJugadorModel> equipoJugador = convertidor.convertirListaEquiposJugadore
					(repositorioEquipoJugador.findByJugador(jugadorJPA));
			
			return new JugadorFullDTO( jugadorModel , equipoJugador) ;
			
		}			
	}

	@Override
	public Object obtenerJugadorPorNombre(String nombre) {
		
		JugadorJPA jugadorJPA = repositorio.findByNombreJugador(nombre);

		
		if(jugadorJPA == null) {
			
			JugadorModel jugadorVacio = null;
			
			log.debug("No encontro datos jugador por parametros por nombre: "+ nombre );
			
			return jugadorVacio;
			
		}else {
			
			JugadorModel jugadorModel = new JugadorModel(jugadorJPA);
			
			return jugadorModel;
					
		}
	}
	
	@Override
	public Object obtenerJugadorPorIdJugador(int idJugador) {
		
		JugadorJPA jugadorJPA = repositorio.findByIdJugador(idJugador);
		
		if(jugadorJPA == null) {
			
			log.debug("No encontro datos jugador por parametro idJugador: "+ idJugador );
			
			return new ResponseErrorModel(MensajeError.COD_OOO9, MensajeError.Mensaje_OOO9);
			
		}else {
			JugadorModel jugador = convertidor.convertirJugadorModel(jugadorJPA);
			
			return jugador;
		}
	
	}


	@Override
	public Object obtenerJugadorFporNombre(String nombre) {
		
		JugadorJPA jugadorJPA = repositorio.findByNombreJugador(nombre);
		
		
		
		if (jugadorJPA == null) {
				
			log.debug("No encontro datos jugador por parametro nombre: "+ nombre );
			
			return new ResponseErrorModel(MensajeError.COD_OOO9, MensajeError.Mensaje_OOO9);
			
		}else {
			
			JugadorModel jugadorModel = new JugadorModel(jugadorJPA);
			
			
			List<FaltaModel> falta = convertidor.convertirListaFalta(repositorioFalta.findByJugador(jugadorJPA));

			return new JugadorFullDTO(falta, jugadorModel);
			
			
		}
			
	}

	@Override
	public Object obtenerJugadorFporNombreGol(String nombre) {
		
		JugadorJPA jugadorJPA = repositorio.findByNombreJugador(nombre);
		
		
		
		if (jugadorJPA == null) {
					
			log.debug("No encontro datos jugador por parametro nombre: "+ nombre );
			
			return new ResponseErrorModel(MensajeError.COD_OOO9, MensajeError.Mensaje_OOO9) ;
			
		}else {
			
			JugadorModel jugadorModel = new JugadorModel(jugadorJPA);
			
			List<GolModel> gol = convertidor.convertirListaGol(repositorioGol.findByJugador(jugadorJPA));
			
			return new JugadorGolFullDTO(jugadorModel, gol);
			
		}
	
	}

	@Override
	public Object obtenerJugadorFullGolyFaltaPorNombre(String nombre) {
		
		JugadorJPA jugadorJPA = repositorio.findByNombreJugador(nombre);
			
		
		if (jugadorJPA == null) {
			
			log.debug("No encontro datos jugador por parametro nombre: "+ nombre );
			
			return new ResponseErrorModel(MensajeError.COD_OOO9, MensajeError.Mensaje_OOO9) ;
			
			
		}else {
			
			JugadorModel jugadorModel = new JugadorModel(jugadorJPA);
			
			List<GolModel> gol = convertidor.convertirListaGol(repositorioGol.findByJugador(jugadorJPA));
			
			List<FaltaModel> falta = convertidor.convertirListaFalta(repositorioFalta.findByJugador(jugadorJPA));
			
			return new JugadorGolFaltaFullDTO(jugadorModel, gol, falta);
			
		}
		
	}

	

}
