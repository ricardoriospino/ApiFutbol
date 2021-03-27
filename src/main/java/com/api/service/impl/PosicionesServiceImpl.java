package com.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.api.jpa.entity.PosicionesJPA;
import com.api.jpa.repository.PosicionesRepository;
import com.api.model.entity.PosicionesModel;
import com.api.service.PosicionesService;
import com.api.util.Convertidor;

@Service("posicionesServiceImpl")
public class PosicionesServiceImpl implements PosicionesService {
	private static final Logger log = LogManager.getLogger(PosicionesServiceImpl.class);
	
	@Autowired
	@Qualifier("repositorioPosiciones")
	private PosicionesRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;

	@Override
	public boolean insertar(PosicionesModel posiciones) {
		
		try {
			repositorio.save(new PosicionesJPA (posiciones));
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean actualizar(PosicionesModel posiciones) {
		try {
			repositorio.save(new PosicionesJPA (posiciones));
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
			Optional<PosicionesJPA> posiciones = repositorio.findById(id);
			
			if(posiciones.isPresent()) {
				repositorio.delete(posiciones.get());
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
	public List<PosicionesModel> obtenerPosiciones() {
		
		return convertidor.convertirListaPosiciones(repositorio.findAll());
	}

}
