package com.api.rest.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.entity.EstadioModel;
import com.api.service.impl.EstadioServiceImpl;

@RestController
@RequestMapping("/apiEstadio")
public class EstadioRestController {
	private static final Logger log = LogManager.getLogger(EstadioRestController.class);
	
	@Autowired
	@Qualifier("estadioServiceImpl")
	private EstadioServiceImpl estadioServiceImpl;
	
	// http://localhost:8090/apiEstadio/estadio
	
	//PUT
	@PutMapping("/estadio")
	public boolean agregarEstadio(@RequestBody EstadioModel estadio) {
		log.info("ini: agregarEstadio()");
		
		log.debug("datos estadio:" + estadio.toString());
		return estadioServiceImpl.insertar(estadio);
	
	}
	
	//POST
	@PostMapping("/estadio")
	public boolean actualizarEstadio(@RequestBody EstadioModel estadio) {
		log.info("ini: actualizarEstadio()");
		
		log.debug("datos estadio:" + estadio.toString());
		return estadioServiceImpl.actualizar(estadio);
	
	}
	
	/*
		 {
	    "nombreEstadio": "Alberto Gallardo",
	    "capacidad": 10000,
	    "ubicacion": "San Martin de Porras , Puente caqueta"   
		}
	 */
	 
	
}
