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

import com.api.model.entity.EntrenadorModel;
import com.api.service.impl.EntrenadorServiceImpl;

@RestController
@RequestMapping("/apiEntrenador")
public class EntrenadorRestController {
	private static final Logger log = LogManager.getLogger(EntrenadorRestController.class);

	@Autowired
	@Qualifier("entrenadorServiceImpl")
	private EntrenadorServiceImpl entrenadorServiceImpl;
	
	// http://localhost:8090/apiEntrenador/entrenador
	
	// PUT
	@PutMapping("/entrenador")
	public boolean agregarEntrenador(@RequestBody EntrenadorModel entrenador) {
		log.info("ini: agregarEntrenador()");
		
		log.debug("datos entrenador:" + entrenador.toString());
		return entrenadorServiceImpl.insertar(entrenador);
	}
	
	// http://localhost:8090/apiEntrenador/entrenador
	//POST
	@PostMapping("/entrenador")
	public boolean actualizarEntrenador(@RequestBody EntrenadorModel entrenador) {
		log.info("ini: actualizar Entrenador()");
		
		log.debug("datos entrenador:" + entrenador.toString());
		return entrenadorServiceImpl.actualizar(entrenador);
	}
	
	/*
	 {
    "nombreEntrenador": "Roberto Mosquera",
    "edad": 50,
    "nacionalidad": "Peruana",
    "aniosExperiencia": 10,
    "titulosGanados": 4
	}
	 */
	
}
