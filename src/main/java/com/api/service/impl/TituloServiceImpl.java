package com.api.service.impl;



import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.api.jpa.entity.EquipoJPA;
import com.api.jpa.entity.TituloJPA;
import com.api.jpa.repository.EquipoRepository;
import com.api.jpa.repository.TituloRepository;
import com.api.model.entity.TituloModel;

import com.api.service.TituloService;
import com.api.util.Convertidor;


@Service("tituloServiceImpl")
public class TituloServiceImpl implements TituloService {
	private static final Logger log = LogManager.getLogger(TituloServiceImpl.class);
	
	@Autowired
	@Qualifier("repositorioTitulo")
	private TituloRepository repositorio;
	
	@Autowired
	@Qualifier("repositorioequipo")
	private EquipoRepository repositorioEquipo;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;

	@Override
	public boolean insertar(TituloModel titulo) {
		
		try {
			EquipoJPA equipoJPA = repositorioEquipo.findByCodigoEquipo(titulo.getCodigoEquipo());
			
			if(equipoJPA == null) {
				log.error("Codigo Equipo no existe");
				return false;
			}
			
			titulo.setEquipo(equipoJPA);
			repositorio.save(new TituloJPA (titulo));
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("error al insertar " + e);
			return false;
		}
	}

	@Override
	public boolean actualizar(TituloModel titulo) {
		
		try {
			EquipoJPA equipoJPA = repositorioEquipo.findByCodigoEquipo(titulo.getCodigoEquipo());
			
			if(equipoJPA == null) {
				log.error("Codigo Equipo no existe");
				return false;
			}
			
			titulo.setEquipo(equipoJPA);
			repositorio.save(new TituloJPA (titulo));
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("error al insertar " + e);
			return false;
		}
		
	}

	@Override
	public boolean borrar(int id) {
		
		try {
			
			
			log.info("Borrar");
			Optional<TituloJPA> titulo = repositorio.findById(id);
			
			if(titulo.isPresent()) {
				repositorio.delete(titulo.get());
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
	public List<TituloModel> obtenerTitulos() {
		
		return convertidor.convertirListaTitulos(repositorio.findAll());
	}

	

}
