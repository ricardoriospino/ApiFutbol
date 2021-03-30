package com.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.jpa.entity.EstadioJPA;
import com.api.jpa.repository.EstadioRepository;
import com.api.model.entity.EstadioModel;
import com.api.service.EstadioService;
import com.api.util.Convertidor;

@Service("estadioServiceImpl")
public class EstadioServiceImpl implements EstadioService {
	private static final Logger log = LogManager.getLogger(EstadioServiceImpl.class);
	
	@Autowired
	@Qualifier("repositorioestadio")
	private EstadioRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;

	@Override
	public boolean insertar(EstadioModel estadio) {
		
		try {
			repositorio.save(new EstadioJPA (estadio));
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean actualizar(EstadioModel estadio) {
		
		try {
			repositorio.save(new EstadioJPA (estadio));
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean borrar(int id) {
		
		try {
			log.info("Borrar");
			Optional<EstadioJPA> estadio = repositorio.findById(id);
			if(estadio.isPresent()) {
				repositorio.delete(estadio.get());
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
	public List<EstadioModel> obtenerEstadios() {
		
		return convertidor.convertirListaEstadio(repositorio.findAll());
	}

	@Override
	public EstadioModel obtenerEstadioPorNombre(String nombre) {
		
		return convertidor.convertirEstadioModel(repositorio.findByNombreEstadio(nombre));
	}

	@Override
	public List<EstadioModel> obtenerEstadiosPaginacion(Pageable paginacion) {
		
		return convertidor.convertirListaEstadio(repositorio.findAll(paginacion).getContent());
	}

}
