package com.api.service.impl;

import java.text.ParseException;
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
import com.api.model.entity.ResponseErrorModel;
import com.api.model.entity.TituloModel;
import com.api.rest.dto.EquipoFullDTO;
import com.api.service.EquipoService;
import com.api.util.ConstanteAPI;
import com.api.util.Convertidor;
import com.api.util.MensajeError;

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
			
			EquipoJPA ultimoEquipoCodigo = repositorio.findTopByOrderByIdEquipoDesc();
			
			String codigo = ultimoEquipoCodigo.getCodigoEquipo();
			
			String [] partes = codigo.split("Q");
			
			String parte1 = partes[0];
			String parte2 = partes[1];
			
			int codigoNumero = Integer.parseInt(parte2);
			
			codigoNumero++;
			
			String codigoNuevo = ConstanteAPI.EQUIPO + "00" + codigoNumero;
			
			equipo.setCodigoEquipo(codigoNuevo);
			
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
			
			EquipoJPA equipoJPA = repositorio.findByIdEquipo(equipo.getIdEquipo());
			
			if(equipoJPA == null) {
				log.error("equipo no existe");
				return false;
			}
			
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
	public Object obtenerEquipoPorNombre(String nombre) {
		
		EquipoJPA equipoJPA = repositorio.findByNombreEquipo(nombre);
		
		
		if (equipoJPA == null) {
			
			log.debug("No encontro datos equipo por parametros por nombre: "+ nombre );
			
			return new ResponseErrorModel(MensajeError.COD_OOO4, MensajeError.Mensaje_OOO4);
			
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
	public Object obtenerEquipoFPorNombre(String nombre) {
		
		EquipoJPA equipoJPA =  repositorio.findByNombreEquipo(nombre);
		
		
		if(equipoJPA == null) {
			
			log.error("No encontro equipo full por parametro  nombre: " + nombre );	
			
			
			return  new ResponseErrorModel(MensajeError.COD_OOO5, MensajeError.Mensaje_OOO5);
		}else {
			
			EquipoModel equipoModel = new EquipoModel(equipoJPA);
			
			List<TituloModel> titulos = convertidor.convertirListaTitulos(repositorioTitulo.findByEquipo
					(equipoJPA));
			
			return new EquipoFullDTO(equipoModel, titulos);
				
		}
		
	}
	
	

	@Override
	public List<EquipoFullDTO> obtenerListaTitulos() {
		
		List<EquipoModel> lstEquipos =  convertidor.convertirListaEquipo(repositorio.findAll());
		
		ArrayList<EquipoJPA> equipos = new ArrayList<EquipoJPA>();	
		
		try {
			equipos = (ArrayList<EquipoJPA>) convertidor.convertirEquipoJPA(lstEquipos);
		} catch (ParseException e) {		
			e.printStackTrace();
		}
		
		List<TituloModel> titulos = null;
		List<EquipoFullDTO> lstEquipoFull = new ArrayList<>();
		EquipoFullDTO equipoFull = null;
		
		for(EquipoJPA equipoJPA : equipos) {
			
			titulos = convertidor.convertirListaTitulos(repositorioTitulo.findByEquipo(equipoJPA));
			equipoFull = new EquipoFullDTO(new EquipoModel(equipoJPA), titulos);
			lstEquipoFull.add(equipoFull);
		}
	
		
		return lstEquipoFull;
	}

}
