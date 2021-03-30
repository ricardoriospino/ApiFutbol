package com.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.jpa.entity.EntrenadorJPA;
import com.api.jpa.repository.EntrenadorRepository;
import com.api.model.entity.EntrenadorModel;
import com.api.service.EntrenadorService;
import com.api.util.Convertidor;


@Service("entrenadorServiceImpl")
public class EntrenadorServiceImpl implements EntrenadorService {
	private static final Logger log = LogManager.getLogger(EntrenadorServiceImpl.class);
	
	@Autowired
	@Qualifier("repositorioentrenador")
	private EntrenadorRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;

	@Override
	public boolean insertar(EntrenadorModel entrenador) {
		
		try {
			repositorio.save(new EntrenadorJPA (entrenador));
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean actualizar(EntrenadorModel entrenador) {
		
		try {
			repositorio.save(new EntrenadorJPA (entrenador));
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean borrar(String nombre, int id) {
		
		try {
			
			EntrenadorJPA entrenador = repositorio.findByNombreEntrenadorAndIdEntrenador(nombre, id);
			repositorio.delete(entrenador);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean borrar(int id) {
		try {
			log.info("Borrar");
			Optional<EntrenadorJPA> entrenador = repositorio.findById(id);
			
			if(entrenador.isPresent()) {
				repositorio.delete(entrenador.get());
			}else {
				log.error("No existe data para ese Id");
				return false;
			}
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<EntrenadorModel> obtenerEntrenadores() {
		
		return convertidor.convertirListaEntrenador(repositorio.findAll());
	}

	@Override
	public EntrenadorModel obtenerEntrenadorPorNombreyNacionalidad(String nombre, String nacionalidad) {
		
		return convertidor.convertirEntrenadorModel(repositorio.findByNombreEntrenadorAndNacionalidad(nombre, nacionalidad));
	}

	@Override
	public List<EntrenadorModel> obtenerEntrenadoresPaginacion(Pageable paginacion) {
		
		return convertidor.convertirListaEntrenador(repositorio.findAll(paginacion).getContent());
	}

}
