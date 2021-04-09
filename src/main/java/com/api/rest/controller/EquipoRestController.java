package com.api.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.entity.EquipoModel;
import com.api.service.impl.EquipoServiceImpl;

@RestController
@RequestMapping("/apiEquipo")
public class EquipoRestController {
	private static final Logger log = LogManager.getLogger(EquipoRestController.class);
	
	@Autowired
	@Qualifier("equipoServiceImpl")
	private EquipoServiceImpl equipoServiceImpl;
	
	// http://localhost:8090/apiEquipo/equipo
	
	//PUT 
	@PutMapping("/equipo")
	public boolean agregarEquipo (@Valid @RequestBody EquipoModel equipo) {
		log.info("ini: agregarEquipo()");
		
		log.debug("datos equipo:" + equipo.toString());
		return equipoServiceImpl.insertar(equipo);
	}
	//-------------------------------------------------------------------
	// http://localhost:8090/apiEquipo/equipo
	//POST
	@PostMapping("/equipo")
	public boolean actualizarEquipo (@RequestBody EquipoModel equipo) {
		log.info("ini: actualizar Equipo()");
		
		log.debug("datos equipo:" + equipo.toString());
		return equipoServiceImpl.actualizar(equipo);
	}
	
	// ------------------------------------------------------------------
	
	//DELETE 
	//http://localhost:8090/apiEquipo/borrarEquipo/11
	@DeleteMapping ("/borrarEquipo/{idBorrar}")
	public boolean borrarEquipo(@PathVariable("idBorrar") int id) {
		log.info("ini: borrarEquipo()");
		
		log.debug("id:" +  id );
		 return equipoServiceImpl.borrar(id);
	}
	
	// -----------------------------------------------------------------
	
	//GET SIN PARAMETROS SIN PAGINACION
	//http://localhost:8090/apiEquipo/equipos
	@GetMapping("/equipos")
	public List<EquipoModel> obtenerEquipo(){
		log.info("ini: obtenerEquipo() ");
		
		return equipoServiceImpl.obtenerEquipos();
	}
	
	// -------------------------------------------------------------------
	
	// GET CON PAGINACION Y TAMAÑO
	// http://localhost:8090/apiEquipo/equiposP?page=0&size=3
	@GetMapping ("/equiposP")
	public List<EquipoModel> obtenerEquiposPaginacion(Pageable paginacion){
		log.info("ini: obtenerEquiposPaginacion()");
		
		return equipoServiceImpl.obtenerEquiposPaginacion(paginacion);
	}

	// -----------------------------------------------------------------------
	
	//GET CON PARAMETROS 
	// http://localhost:8090/apiEquipo/equipo/Sporting Cristal
	@GetMapping ("/equipo/{pnombre}")
	public  EquipoModel obtenerEquipoPorNombre (@PathVariable("pnombre")String nombre ) {
				
		log.info("ini: obtenerEquipoPorNombre()");
				
		log.debug("nombre:" +  nombre );
		return  equipoServiceImpl.obtenerEquipoPorNombre(nombre);
	}
	
}

