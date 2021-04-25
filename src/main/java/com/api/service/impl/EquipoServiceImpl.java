package com.api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.jpa.entity.EquipoEstadioJPA;
import com.api.jpa.entity.EquipoJPA;
import com.api.jpa.entity.EstadioJPA;
import com.api.jpa.repository.EquipoEstadioRepository;
import com.api.jpa.repository.EquipoRepository;
import com.api.jpa.repository.EstadioRepository;
import com.api.jpa.repository.TituloRepository;
import com.api.model.entity.EquipoEstadioModel;
import com.api.model.entity.EquipoModel;
import com.api.model.entity.TituloModel;
import com.api.rest.dto.EquipoFullDTO;
import com.api.service.EquipoService;
import com.api.util.Convertidor;

@Service("equipoServiceImpl")
public class EquipoServiceImpl implements EquipoService {
	private static final Logger log = LogManager.getLogger(EquipoServiceImpl.class);
	
	@Autowired
	@Qualifier("repositorioTitulo")
	private TituloRepository repositorioTitulo;

	
	
	@Autowired
	@Qualifier("repositorioequipo")
	private EquipoRepository repositorio;
	
	@Autowired
	@Qualifier("repositorioestadio")
	private EstadioRepository repositorioEstadio;
	
	@Autowired
	@Qualifier("repositorioEquipoEstadio")
	private EquipoEstadioRepository repositorioEquipoEstadio;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;

	@Override
	public boolean insertar(EquipoModel equipo) {
		
		try {
			
			EquipoJPA equipoJPA = repositorio.findByCodigoEquipo(equipo.getCodigoEquipo());
			
			EquipoJPA equipoNombre = repositorio.findByNombreEquipo(equipo.getNombreEquipo());
			
			if (equipoJPA != null || equipoNombre != null  ) {
				
				log.error(" Ya existe");
				return false;
			}
			
			repositorio.save(new EquipoJPA (equipo));
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al insertar " + e);
			return false;
		}
	}
	
	@Override
	public boolean insertarEquipoEstadio(EquipoEstadioModel equipoEstadio) {
		
		try {
			
			EquipoJPA equipoJPA = repositorio.findByCodigoEquipo(equipoEstadio.getCodigoEquipo());
			
			EstadioJPA estadioJPA = repositorioEstadio.findByCodigoEstadio(equipoEstadio.getCodigoEstadio());
			
			
			if (equipoJPA == null   ) {	
				log.error(" equipo no existe");
				return false;
			}
			
			
			EquipoEstadioJPA ee = new EquipoEstadioJPA( equipoJPA, estadioJPA);
			
			repositorioEquipoEstadio.save(ee);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al insertar EquipoService " + e);
			return false;
		}
	}


	@Override
	public boolean actualizar(EquipoModel equipo) {
		
		try {
			
			repositorio.save(new EquipoJPA (equipo));
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al actualizar " + e);
			return false;
		}
	}

	@Override
	public boolean borrar(int id  ) {
		
		try {
			log.info("Borrar");
			Optional<EquipoJPA> equipo = repositorio.findById(id);
			
			if(equipo.isPresent()) {
				repositorio.delete(equipo.get());
				
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
	public List<EquipoModel> obtenerEquipos() {
		
		return convertidor.convertirListaEquipo(repositorio.findAll());
	}

	@Override
	public EquipoModel obtenerEquipoPorNombre(String nombre) {
		
		EquipoJPA equipoJPA = repositorio.findByNombreEquipo(nombre);
		
		
		if (equipoJPA == null) {
			
			EquipoModel equipoVacio = null;
			
			log.debug("No encontro datos equipo por parametros por nombre: "+ nombre );
			
			return equipoVacio;
			
		}else {
			
			EquipoModel equipo = convertidor.convertirEquipoModel(equipoJPA);
			
			return equipo;
			
		}
		
		
	}

	@Override
	public List<EquipoModel> obtenerEquiposPaginacion(Pageable paginacion) {
		
		return convertidor.convertirListaEquipo(repositorio.findAll(paginacion).getContent());
	}

	@Override
	public EquipoFullDTO obtenerEquipoFPorNombre(String nombre) {
		
		EquipoModel equipo = obtenerEquipoPorNombre(nombre);
		
		if (equipo == null) {
			
			EquipoFullDTO equipoFullvacio = null;
			
			log.debug("No encontro datos equipo por parametro  nombre: "+ nombre );
			
			return equipoFullvacio;
					
			
		}else {
			
			List<TituloModel> titulos = convertidor.convertirListaTitulos(repositorioTitulo.findByEquipo(new EquipoJPA(equipo)));
			
			return new EquipoFullDTO(equipo, titulos);
			
		}
		
		
	}

	@Override
	public EquipoFullDTO obtenerListaTitulos() {
		
		List<EquipoModel> equipo =  convertidor.convertirListaEquipo(repositorio.findAll());
	
		ArrayList<EquipoJPA> equipoTitulos = new ArrayList<EquipoJPA>();
		
		equipoTitulos = (ArrayList<EquipoJPA>) convertidor.convertirEquipoJPA(equipo);
		
		List<TituloModel> titulo = null;
		
		for (EquipoJPA equipoJPA : equipoTitulos) {
			
			 titulo = convertidor.convertirListaTitulos(repositorioTitulo.findByEquipo(equipoJPA));
			
		}	
		return new EquipoFullDTO(equipo,  equipoTitulos);
	}

}
