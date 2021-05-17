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
import com.api.jpa.repository.EquipoEstadioRepository;
import com.api.jpa.repository.EstadioRepository;
import com.api.model.entity.EquipoEstadioModel;
import com.api.model.entity.EstadioModel;
import com.api.model.entity.ResponseErrorModel;
import com.api.rest.dto.EstadioFullDTO;
import com.api.service.EstadioService;
import com.api.util.Convertidor;
import com.api.util.MensajeError;

@Service("estadioServiceImpl")
public class EstadioServiceImpl implements EstadioService {
	private static final Logger log = LogManager.getLogger(EstadioServiceImpl.class);
	
	@Autowired
	@Qualifier("repositorioestadio")
	private EstadioRepository repositorio;
	
	@Autowired
	@Qualifier("repositorioEquipoEstadio")
	private EquipoEstadioRepository repositorioEquipoEstadio;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;

	@Override
	public boolean insertar(EstadioModel estadio) {
		
		try {
			
			EstadioJPA estadioJPA = repositorio.findByCodigoEstadio(estadio.getCodigoEstadio());
			
			if(estadioJPA != null) {
				log.error("Codigo Ya existe");
				return false;
			}
			
			repositorio.save(new EstadioJPA (estadio));
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al insertar " + e);
			return false;
		}
	}

	@Override
	public boolean actualizar(EstadioModel estadio) {
		
		try {
			
			EstadioJPA estadioJPA = repositorio.findByIdEstadio(estadio.getIdEstadio());
			
			if(estadioJPA == null) {
				log.error("estadio no existe");
				return false;
			}
			
			repositorio.save(new EstadioJPA (estadio));
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al actualizar " + e);
			return false;
		}
	}

	@Override
	public boolean borrar(int id ) {
		
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
			log.error("Error al borrar " + e);
			return false;
		}
	}

	@Override
	public List<EstadioModel> obtenerEstadios() {
		
		return convertidor.convertirListaEstadio(repositorio.findAll());
	}

	@Override
	public Object obtenerEstadioPorNombre(String nombre) {
		
		
		EstadioJPA estadioJPA = repositorio.findByNombreEstadio(nombre);
		
		if(estadioJPA == null) {
					
			log.debug("No encontro datos de estadio por parametro nombre: "+ nombre );
			return new ResponseErrorModel(MensajeError.COD_OOO6, MensajeError.Mensaje_OOO6);
					
		}else {
			
			EstadioModel estadio = convertidor.convertirEstadioModel(estadioJPA);
			return estadio;
			
		}
		
	}

	@Override
	public List<EstadioModel> obtenerEstadiosPaginacion(Pageable paginacion) {
		
		return convertidor.convertirListaEstadio(repositorio.findAll(paginacion).getContent());
	}

	@Override
	public Object obtenerEstadioPorCodigo(String codigo) {
		
		EstadioJPA estadioJPA = repositorio.findByCodigoEstadio(codigo);
				
		if(estadioJPA == null) {
		
			log.debug("No encontro datos estadio por parametro  codigo: "+ codigo );
			
			return new ResponseErrorModel(MensajeError.COD_OOO6 , MensajeError.COD_OOO6);
			
		}else {
			
			EstadioModel estadio = convertidor.convertirEstadioModel(estadioJPA);
			
			return estadio;
			
		}
	}

	@Override
	public Object obtenerEstadioPorFcodigo(String codigo) {
		
		EstadioJPA estadioJPA = repositorio.findByCodigoEstadio(codigo);

		if (estadioJPA == null) {
	
			log.debug("No encontro datos estadio por parametro  codigo: "+ codigo );
			
			return new ResponseErrorModel(MensajeError.COD_OOO7, MensajeError.Mensaje_OOO7);
			
		}else {
			
			EstadioModel estadioModel = new EstadioModel(estadioJPA);
			
			List<EquipoEstadioModel> equipoEstadio = convertidor.convertirListaEquipoEstadios
					(repositorioEquipoEstadio.findByEstadio(estadioJPA));
			
			return new EstadioFullDTO(estadioModel, equipoEstadio);
			
		}		
	}

}
