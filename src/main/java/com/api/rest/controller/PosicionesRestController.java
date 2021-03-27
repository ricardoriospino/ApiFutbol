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

import com.api.model.entity.PosicionesModel;
import com.api.service.impl.PosicionesServiceImpl;

@RestController
@RequestMapping("/apiPosiciones")
public class PosicionesRestController {
	private static final Logger log = LogManager.getLogger(PosicionesRestController.class);
	
	@Autowired
	@Qualifier("posicionesServiceImpl")
	private PosicionesServiceImpl posicionesServiceImpl;
	
	// http://localhost:8090/apiPosiciones/posiciones

	// PUT
	@PutMapping("/posiciones")
	public boolean agregarPosiciones(@RequestBody PosicionesModel posiciones) {
		log.info("ini: agregarPosiciones()");
			
		log.debug("datos Posiciones:" + posiciones.toString());
		return posicionesServiceImpl.insertar(posiciones);
	}
	
	// POST
	@PostMapping("/posiciones")
	public boolean actualizarPosiciones(@RequestBody PosicionesModel posiciones) {
		log.info("ini: actualizarPosiciones()");
				
		log.debug("datos Posiciones:" + posiciones.toString());
		return posicionesServiceImpl.actualizar(posiciones);
	}
	
	/*
	 {
    "temporada": 2021,
    "nombreEquipo": "Sporting Cristal",
    "partidosJugados": 5,
    "partidosGanados": 3,
    "partidosEmpatados": 1 ,
    "partidosPerdidos": 1,
    "puntos": 10
	}
	 */
	 
}
