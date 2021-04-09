package com.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.api.jpa.entity.JugadorJPA;
import com.api.jpa.repository.JugadorRepository;
import com.api.model.entity.JugadorModel;
import com.api.service.JugadorService;
import com.api.util.Convertidor;

@Service("jugadorServiceImpl")
public class JugadorServiceImpl implements JugadorService {
	private static final Logger log = LogManager.getLogger(JugadorServiceImpl.class);
	
	@Autowired
	@Qualifier("repositoriojugador")
	private JugadorRepository repositorio;
	
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

}
