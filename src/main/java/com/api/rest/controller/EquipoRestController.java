package com.api.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.entity.EquipoEstadioModel;
import com.api.model.entity.EquipoModel;

import com.api.rest.dto.EquipoFullDTO;
import com.api.service.impl.EquipoServiceImpl;


@RestController
@RequestMapping("/apiFutbol")
public class EquipoRestController {
	private static final Logger log = LogManager.getLogger(EquipoRestController.class);
	
	
	
	@Autowired
	@Qualifier("equipoServiceImpl")
	private EquipoServiceImpl equipoServiceImpl;
	
	// http://localhost:8090/apiFutbol/equipo
	
//	//PUT 
//	@PutMapping("/equipo")
//	public boolean agregarEquipo (@Valid @RequestBody EquipoModel equipo) {
//		log.info("ini: agregarEquipo()");
//		
//		log.debug("datos equipo:" + equipo.toString());
//		return equipoServiceImpl.insertar(equipo);
//	}
//	
	
	
	//PUT 
		@PutMapping("/equipo")
		public ResponseEntity<?> agregarEquipo (@Valid @RequestBody EquipoModel equipo) {
			log.info("ini: agregarEquipo()");
			
			log.debug("datos equipo:" + equipo.toString());
			
			boolean flag = equipoServiceImpl.insertar(equipo);
			
			if(flag)
				return new ResponseEntity<>(HttpStatus.OK);
			else
				return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
		}
		
	
	//---------------------------------------------------------------------
	// http://localhost:8090/apiFutbol/equipo-estadio
	
	//PUT 
	@PutMapping("/equipo-estadio")
	public  ResponseEntity<?> agregarEquipoEstadio(@Valid @RequestBody EquipoEstadioModel equipoEstadio) {
		log.info("ini: agregarEquipoEstadio()");
			
		log.debug("datos equipo estadio:" + equipoEstadio.toString());
		
		boolean flag = equipoServiceImpl.insertarEquipoEstadio(equipoEstadio);
		
		if(flag)
			return new ResponseEntity<>(HttpStatus.OK);
		else		
			return new ResponseEntity<>(false,HttpStatus.CONFLICT);
		
	}
	
	//-------------------------------------------------------------------
	// http://localhost:8090/apiFutbol/equipo
	//POST
	@PostMapping("/equipo")
	public ResponseEntity<?>  actualizarEquipo (@RequestBody EquipoModel equipo) {
		log.info("ini: actualizar Equipo()");
		
		log.debug("datos equipo:" + equipo.toString());
		
		boolean flag = equipoServiceImpl.actualizar(equipo);		

		if(flag)
			return new ResponseEntity<>(HttpStatus.OK);
		else		
			return new ResponseEntity<>(false,HttpStatus.CONFLICT);
		
		
	}
	
	// ------------------------------------------------------------------
	
	//DELETE 
	//http://localhost:8090/apiFutbol/borrarEquipo/11
	@DeleteMapping ("/borrarEquipo/{idBorrar}")
	public ResponseEntity<?> borrarEquipo(@PathVariable("idBorrar") int id) {
		log.info("ini: borrarEquipo()");
		
		log.debug("id:" +  id );
		
		boolean flag = equipoServiceImpl.borrar(id);	
		
		if(flag)
			return new ResponseEntity<>(HttpStatus.OK);
		else		
			return new ResponseEntity<>(false,HttpStatus.CONFLICT);
		 
	}
	
	// -----------------------------------------------------------------
	
	//GET SIN PARAMETROS SIN PAGINACION
	//http://localhost:8090/apiFutbol/equipos
	@GetMapping("/equipos")
	public List<EquipoModel> obtenerEquipo(){
		log.info("ini: obtenerEquipo() ");
		
		return equipoServiceImpl.obtenerEquipos();
	}
	
	// -------------------------------------------------------------------
	
	// GET CON PAGINACION Y TAMAÑO
	// http://localhost:8090/apiFutbol/equiposP?page=0&size=3
	@GetMapping ("/equiposP")
	public List<EquipoModel> obtenerEquiposPaginacion(Pageable paginacion){
		log.info("ini: obtenerEquiposPaginacion()");
		
		return equipoServiceImpl.obtenerEquiposPaginacion(paginacion);
	}

	// -----------------------------------------------------------------------
	
	//GET CON PARAMETROS 
	// http://localhost:8090/apiFutbol/equipo/Sporting Cristal
	@GetMapping ("/equipo/{pnombre}")
	public  Object obtenerEquipoPorNombre (@PathVariable("pnombre")String nombre ) {
				
		log.info("ini: obtenerEquipoPorNombre()");
				
		log.debug("nombre:" +  nombre );
		return  equipoServiceImpl.obtenerEquipoPorNombre(nombre);
	}
	
	
	// -----------------------------------------------------------------------
	
	//GET CON PARAMETROS 
	// http://localhost:8090/apiFutbol/equipof/Sporting Cristal
	@GetMapping ("/equipof/{pnombre}")
	public  Object obtenerEquipoPorNombreFull (@PathVariable("pnombre")String nombre ) {
					
		log.info("ini: obtenerEquipoPorNombreFull()");
					
		log.debug("nombre:" +  nombre );
			
			return equipoServiceImpl.obtenerEquipoFPorNombre(nombre);
			
		

	}

	// TODOS LOS titulos de cada equipo
	// http://localhost:8090/apiFutbol/listaTitulosxEquipos
	@GetMapping("/listaTitulosxEquipos")
	public List<EquipoFullDTO> obtenerTitulosxEquipo(){
		
		log.info("obtenerTitulosxEquipo()");
		
		return equipoServiceImpl.obtenerListaTitulos();
	}
	
	
	
}

