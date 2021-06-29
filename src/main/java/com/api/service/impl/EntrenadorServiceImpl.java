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
import com.api.jpa.entity.EquipoEntrenadorJPA;
import com.api.jpa.entity.EquipoJPA;
import com.api.jpa.repository.EntrenadorRepository;
import com.api.jpa.repository.EquipoEntrenadorRepository;
import com.api.jpa.repository.EquipoRepository;
import com.api.model.entity.EntrenadorModel;
import com.api.model.entity.EquipoEntrenadorModel;

import com.api.model.entity.ResponseErrorModel;
import com.api.rest.dto.EntrenadorFullDTO;
import com.api.service.EntrenadorService;
import com.api.util.ConstanteAPI;
import com.api.util.Convertidor;
import com.api.util.MensajeError;


@Service("entrenadorServiceImpl")
public class EntrenadorServiceImpl implements EntrenadorService {
	private static final Logger log = LogManager.getLogger(EntrenadorServiceImpl.class);
	
	@Autowired
	@Qualifier("repositorioentrenador")
	private EntrenadorRepository repositorio;
	
	@Autowired
	@Qualifier("repositorioEquipoEntrenador")
	private EquipoEntrenadorRepository repositorioEquipoEntrenador;
	
	@Autowired
	@Qualifier("repositorioequipo")
	private EquipoRepository repositorioEquipo;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;

	@Override
	public boolean insertar(EntrenadorModel entrenador) {
		
		try {
			EntrenadorJPA entrenadorJPA = repositorio.findBycodigoEntrenador(entrenador.getCodigoEntrenador());
			
			if(entrenadorJPA != null) {
				log.error("Codigo Ya existe");
				return false;
			}
			
			EntrenadorJPA ultimoEntrenadorCodigo = repositorio.findTopByOrderByIdEntrenadorDesc();
			
			String codigo = ultimoEntrenadorCodigo.getCodigoEntrenador();
			
			String [] partes = codigo.split("N");
			
			String parte1 = partes[0];
			String parte2 = partes[1];
			
			int codigoNumero = Integer.parseInt(parte2);
			
			codigoNumero++;
			
			String codigoNuevo = ConstanteAPI.ENTRENADOR + "00" + codigoNumero;
			
			entrenador.setCodigoEntrenador(codigoNuevo);
			
			repositorio.save(new EntrenadorJPA (entrenador));
			
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al insertar " + e);
			return false;
		}
	}
	
	@Override
	public boolean insertarEntrenadorEquipo(EquipoEntrenadorModel entrenadorEquipo) {
		
		try {
			
			EquipoJPA equipoJPA = repositorioEquipo.findByCodigoEquipo(entrenadorEquipo.getCodigoEquipo());
			
			EntrenadorJPA entrenadorJPA = repositorio.findBycodigoEntrenador(entrenadorEquipo.getCodigoEntrenador());
			
			if(entrenadorJPA == null) {
				log.error("Entrenador no existe");
				return false;
			}
			
			if(equipoJPA == null) {
				log.error("Equipo no existe");
				return false;
			}
			
			EquipoEntrenadorJPA ee = new EquipoEntrenadorJPA( equipoJPA, entrenadorJPA, entrenadorEquipo.getAnio(), entrenadorEquipo.getPartidosJugados());
			
			EquipoEntrenadorJPA equipoEntrenador = repositorioEquipoEntrenador.findByAnioAndEquipoAndEntrenador( entrenadorEquipo.getAnio(), equipoJPA, entrenadorJPA);
			
			
			if(equipoEntrenador != null) {
				log.error("No puede ser del mismo año");
				return false;
			}
			
			repositorioEquipoEntrenador.save(ee);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al insertar " + e);
			return false;
		}
	}

	@Override
	public boolean actualizar(EntrenadorModel entrenador) {
		
		try {
			
			EntrenadorJPA entrenadorJPA = repositorio.findByIdEntrenador(entrenador.getIdEntrenador());
			
			if(entrenadorJPA == null) {
				log.error("entrenador no existe");
				return false;
			}

			repositorio.save(new EntrenadorJPA (entrenador));
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al actualizar " + e);
			return false;
		}
	}

	@Override
	public boolean borrar(String nombre, int id , int partidosJugados) {
		
		try {
			
			
			
			List<EquipoEntrenadorJPA> equipoEntrenador = repositorioEquipoEntrenador.findByPartidosJugados(partidosJugados);
			
			if(equipoEntrenador == null) {
				
				EntrenadorJPA entrenador = repositorio.findByNombreEntrenadorAndIdEntrenador(nombre, id);
				repositorio.delete(entrenador);
				return true;
			}else {
				log.error("no se puede borrar por que tiene data en otras tablas ");
				return false;
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al borrar " + e);
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
			log.error("Error al borrar " + e);
			return false;
		}
	}

	@Override
	public List<EntrenadorModel> obtenerEntrenadores() {
		
		return convertidor.convertirListaEntrenador(repositorio.findAll());
	}

	@Override
	public Object obtenerEntrenadorPorNombreyNacionalidad(String nombre, String nacionalidad) {
			
		 EntrenadorJPA entrenadorJPA = repositorio.findByNombreEntrenadorAndNacionalidad(nombre, nacionalidad);
		 	 
		 	if(entrenadorJPA == null) {

				log.error("No encontro datos nombre: " + nombre + " y nacionalidad : " + nacionalidad);
							
				return  new ResponseErrorModel(MensajeError.COD_OOO1, MensajeError.Mensaje_OOO1);
				
			}else {
				
				EntrenadorModel entrenador = convertidor.convertirEntrenadorModel(entrenadorJPA);
				
				return entrenador ;
			}		 
	
	}
	
	@Override
	public List<EntrenadorModel> obtenerEntrenadorPorNacionalidad(String nacionalidad) {
		
		List<EntrenadorJPA> listaentrenadorJPA = repositorio.findByNacionalidad(nacionalidad);
		
		if (listaentrenadorJPA == null) {
			
			List<EntrenadorModel> listaEntrenadorVacio = null;
			
			log.error(" No encontro lista entrenadores por parametro Nacionalidad : " + nacionalidad);
			
			return listaEntrenadorVacio;
		}else {
			
			List<EntrenadorModel> listaEntrenador = convertidor.convertirListaEntrenador(listaentrenadorJPA);
			
			return listaEntrenador;
		}		
		
	}

	
	@Override
	public List<EntrenadorModel> obtenerEntrenadoresPaginacion(Pageable paginacion) {
		
		return convertidor.convertirListaEntrenador(repositorio.findAll(paginacion).getContent());
	}
	
	@Override
	public EntrenadorModel obtenerEntrenadorPorCodigo(String codigo) {
		
		EntrenadorJPA entrenadorJPA = repositorio.findBycodigoEntrenador(codigo);
		
		
		if(entrenadorJPA == null) {
			
			EntrenadorModel entrenadorVacio = null;	
			
			log.error("No encontro entrenador por parametro  codigo: " + codigo );	
			
			return  entrenadorVacio;
			
		}else {
			
			EntrenadorModel entrenador = convertidor.convertirEntrenadorModel(entrenadorJPA);
			
			return entrenador ;			
		}
		
	}
	
	

	@Override
	public Object obtenerEntrenadorFporCodigo(String codigo) {
		
		EntrenadorJPA entrenador =  repositorio.findBycodigoEntrenador(codigo);
		
		
		if (entrenador == null) {
				
			log.error("No encontro entrenador por parametro  codigo: " + codigo );	
			
			
			return  new ResponseErrorModel(MensajeError.COD_OOO3, MensajeError.Mensaje_OOO3);
			
		}else {
			
			EntrenadorModel entrenadorModel = new EntrenadorModel(entrenador);
			
			List<EquipoEntrenadorModel> equipo = convertidor.convertirListaEquiposEntrenador
					(repositorioEquipoEntrenador.findByEntrenador(entrenador));		
			
			return new EntrenadorFullDTO(entrenadorModel, equipo);
			
		}	
	}

}
