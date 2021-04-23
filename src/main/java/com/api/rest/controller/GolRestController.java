package com.api.rest.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.entity.GolModel;
import com.api.service.impl.GolServiceImpl;

@RestController
@RequestMapping("/apiFutbol")
public class GolRestController {
	private static final Logger log = LogManager.getLogger(GolRestController.class);
	
	@Autowired
	@Qualifier("golServiceImpl")
	private GolServiceImpl golServiceImpl;
	
	
	// Jugadores goles
	//http://localhost:8090/apiFutbol/goles
	@GetMapping ("/goles")
	public List<GolModel> obtenerListaGoles(){
		log.info("ini: obtenerListaGoles() ");
		
		return golServiceImpl.obtenerGoles();
	}
}
