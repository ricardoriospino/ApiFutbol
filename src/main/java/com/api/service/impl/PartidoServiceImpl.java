package com.api.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.jpa.entity.EquipoJPA;
import com.api.jpa.entity.JugadorJPA;
import com.api.jpa.entity.PartidoJPA;
import com.api.jpa.repository.EquipoRepository;
import com.api.jpa.repository.FaltaRepository;
import com.api.jpa.repository.GolRepository;
import com.api.jpa.repository.PartidoRepository;
import com.api.model.entity.FaltaModel;
import com.api.model.entity.GolModel;
import com.api.model.entity.PartidoModel;
import com.api.rest.dto.PartidoFullDTO;
import com.api.service.PartidoService;
import com.api.util.Convertidor;
@Service("partidoServiceImpl")
public class PartidoServiceImpl implements PartidoService {

	private static final Logger log = LogManager.getLogger(PartidoServiceImpl.class);
	
	
	@Autowired
	@Qualifier("repositorioequipo")
	private EquipoRepository repositorioEquipo;

	@Autowired
	@Qualifier("repositorioPartido")
	private PartidoRepository repositorioPartido;
	
	@Autowired
	@Qualifier("repositorioFalta")
	private FaltaRepository repositorioFalta;
	
	@Autowired
	@Qualifier("repositorioGol")
	private GolRepository repositorioGol;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;
	
	@Override
	public boolean insertarPartido(PartidoModel partido) {
		
		try {
			
		
			EquipoJPA equipoJPA1 = repositorioEquipo.findByCodigoEquipo(partido.getCodigoEquipo1());
			
			EquipoJPA equipoJPA2 = repositorioEquipo.findByCodigoEquipo(partido.getCodigoEquipo2());
			
			if(equipoJPA1 == null) {
				log.error("Equipo 1 no  existe");
				return false;
			}
			
			if(equipoJPA2 == null) {
				log.error("Equipo 2 no  existe");
				return false;
			}
			
			PartidoJPA p = new PartidoJPA(partido.getCodigoPartido(), partido.getFechaHora(), partido.getNumeroFaltas(),
										 partido.getNumeroGoles(), partido.getGolesEquipo1(), partido.getGolesEquipo2(), 
										 partido.getFaltasEquipo1(), partido.getFaltasEquipo2(), partido.getGanador(), 
										 partido.getPerdedor(), partido.getArbitro(), equipoJPA1, equipoJPA2);
			
			repositorioPartido.save(p);
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			log.error("Error al insertar " + e);
			return false;
		}
	}

	@Override
	public boolean actualizar(PartidoModel partido) {
		
		try {
			
			
			EquipoJPA equipoJPA1 = repositorioEquipo.findByCodigoEquipo(partido.getCodigoEquipo1());
			
			EquipoJPA equipoJPA2 = repositorioEquipo.findByCodigoEquipo(partido.getCodigoEquipo2());
			
			if(equipoJPA1 == null) {
				log.error("Equipo 1 no  existe");
				return false;
			}
			
			if(equipoJPA2 == null) {
				log.error("Equipo 2 no  existe");
				return false;
			}
	
			
			repositorioPartido.save(new PartidoJPA(partido));
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			log.error("Error al actualizar " + e);
			return false;
		}
	}

	@Override
	public boolean borrar(int id ) {
		
		try {

			log.info("Borrar");
			Optional<PartidoJPA> partido = repositorioPartido.findById(id);
				
			
			if(partido.isPresent()) {
				repositorioPartido.delete(partido.get());
			}else {
				log.error("No existe data para ede Id");
				return false;
			}
			
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			log.error("Error al borrar " + e);
			return false;
		}
	}

	@Override
	public List<PartidoModel> obtenerPartidos() {
		
		return convertidor.convertirListaPartido(repositorioPartido.findAll());
	}

	@Override
	public List<PartidoModel> obtenerPartidosPorArbitro(String arbitro) {
		
		return convertidor.convertirListaPartido(repositorioPartido.findByArbitro(arbitro));
	}

	@Override
	public List<PartidoModel> obtenerPartidosPorFecha(Date fechaPartido) {
		
		return convertidor.convertirListaPartido(repositorioPartido.findByFechaHora(fechaPartido));
	}

	@Override
	public List<PartidoModel> obtenerPartidosPaginados(Pageable paginacion) {
		
		return convertidor.convertirListaPartido(repositorioPartido.findAll(paginacion).getContent());
	}
	
	@Override
	public PartidoModel obtenerPartidoPorCodigo(String codigo) {
		
		return convertidor.convertirPartidoModel(repositorioPartido.findByCodigoPartido(codigo));
	}

	@Override
	public PartidoFullDTO obtenerPartidoFporCodigo(String codigo) {
		
		PartidoModel partidoModel = obtenerPartidoPorCodigo(codigo);
		
		List<GolModel> gol = convertidor.convertirListaGol(repositorioGol.findByPartido(new PartidoJPA(partidoModel)));
		
		List<FaltaModel> falta = convertidor.convertirListaFalta(repositorioFalta.findByPartido(new PartidoJPA(partidoModel)));
		
		return new PartidoFullDTO(partidoModel, gol, falta);
	}

	

}