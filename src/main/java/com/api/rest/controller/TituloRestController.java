package com.api.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.api.model.entity.TituloModel;
import com.api.service.impl.TituloServiceImpl;

@RestController
@RequestMapping("/apiFutbol")
public class TituloRestController {
	private static final Logger log = LogManager.getLogger(TituloRestController.class);
	
	@Autowired
	@Qualifier("tituloServiceImpl")
	private TituloServiceImpl tituloServiceImpl;
	
	
	// http://localhost:8090/apiFutbol/titulo
	
	//PUT 
	@PutMapping("/titulo")
	public boolean agregarTitulo (@Valid @RequestBody TituloModel titulo) {
		log.info("ini: agregarTitulo()");
		
		log.debug("datos titulos:" + titulo.toString());
		
		return tituloServiceImpl.insertar(titulo);
	}
	//-------------------------------------------------------------------
	
	// http://localhost:8090/apiFutbol/titulo
	
	//POST
	@PostMapping("/titulo")
	public boolean actualizarTitulo (@Valid @RequestBody TituloModel titulo) {
		log.info("ini: actualizarTitulo()");
			
		log.debug("datos titulos:" + titulo.toString());
			
		return tituloServiceImpl.actualizar(titulo);
	}
	
	//--------------------------------------------------------------------------
	//DELETE
	//http://localhost:8090/apiFutbol/borrarTitulo/1
	
	@DeleteMapping ("/borrarTitulo/{idTitulo}")
	public boolean borrarTitulo (@PathVariable("idTitulo") int id ) {
		
		log.info("ini: borrarTitulo()");
		log.debug("id:" +  id );
		
		return tituloServiceImpl.borrar(id);
	}
	
	// --------------------------------------------------------------------------
	//GET SIN PARAMETROS SIN PAGINACION 
	// http://localhost:8090/apiFutbol/titulos
	
	@GetMapping("/titulos")
	public List<TituloModel> obtenerTitulos(){
		log.info("ini: obtenerTitulos() ");
			
		return tituloServiceImpl.obtenerTitulos();
	}
	
}

