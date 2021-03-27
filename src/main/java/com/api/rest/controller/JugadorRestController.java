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

import com.api.model.entity.JugadorModel;
import com.api.service.impl.JugadorServiceImpl;

@RestController
@RequestMapping("/apiJugador")
public class JugadorRestController {
	private static final Logger log = LogManager.getLogger(JugadorRestController.class);
	
	@Autowired
	@Qualifier("jugadorServiceImpl")
	private JugadorServiceImpl jugadorServiceImpl;
	
	// http://localhost:8090/apiJugador/jugador
	
	//PUT
	@PutMapping("/jugador")
	public boolean agregarJugador(@RequestBody JugadorModel jugador) {
		log.info("ini: agregarJugador()");
		
		log.debug("datos jugador:" + jugador.toString());
		return jugadorServiceImpl.insertar(jugador);
	}
	
	//POST
	@PostMapping("/jugador")
	public boolean actualizarJugador(@RequestBody JugadorModel jugador) {
		log.info("ini: actualizarJugador()");
			
		log.debug("datos jugador:" + jugador.toString());
		return jugadorServiceImpl.actualizar(jugador);
	}
	
	/*
	 {
    "nombreJugador": "Horacio Calcaterra",
    "edad": 35,
    "aniosDeCarrera": 15,
    "nacionalidad": "Argentina",
    "dorsal": 7 ,
    "posicion": "Central"
	}
	 */
	
}
