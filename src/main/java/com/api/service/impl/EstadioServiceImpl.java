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
import com.api.util.ConstanteAPI;
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
			
			EstadioJPA ultimoEstadioCodigo = repositorio.findTopByOrderByIdEstadioDesc();
			
			String codigo = ultimoEstadioCodigo.getCodigoEstadio();
			
			String [] partes = codigo.split("S");
			
			String parte1 = partes[0];
			String parte2 = partes[1];
			
			int codigoNumero = Integer.parseInt(parte2);
			
			codigoNumero++;
			
			String codigoNuevo = generarCodigoEstadio(codigoNumero);

			estadio.setCodigoEstadio(codigoNuevo);
			
			repositorio.save(new EstadioJPA (estadio));
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al insertar " + e);
			return false;
		}
	}
	
	private String generarCodigoEstadio(int codigoNumero) {
		

		String longitudNumero = String.valueOf(codigoNumero);
		
		String codigoNuevo ="";
		
		if ( 1 > longitudNumero.length()) {			
			 codigoNuevo = ConstanteAPI.ESTADIO + "00000" + codigoNumero;	
		}else if(2 > longitudNumero.length()) {
			 codigoNuevo = ConstanteAPI.ESTADIO + "0000" + codigoNumero;
		}else if(3 > longitudNumero.length()) {
			codigoNuevo = ConstanteAPI.ESTADIO + "000" + codigoNumero;
		}else if(4 >  longitudNumero.length()) {
			codigoNuevo = ConstanteAPI.ESTADIO + "00" + codigoNumero;
		}else if(5 >  longitudNumero.length()) {
			codigoNuevo = ConstanteAPI.ESTADIO + "0" +  codigoNumero;
		}else {
			codigoNuevo = ConstanteAPI.ESTADIO + codigoNumero;
		}
	
		return codigoNuevo;
		
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
	public Object obtenerEstadioPorIdEstadio(int idEstadio) {
		
		EstadioJPA estadioJPA = repositorio.findByIdEstadio(idEstadio);
		
		if (estadioJPA == null) {
			
			log.debug("No encontro datos estadio por parametro  idEstadio: "+ idEstadio );
			
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
