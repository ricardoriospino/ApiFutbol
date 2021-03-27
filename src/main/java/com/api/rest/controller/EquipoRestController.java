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
	public boolean agregarEquipo (@RequestBody EquipoModel equipo) {
		log.info("ini: agregarEquipo()");
		
		log.debug("datos equipo:" + equipo.toString());
		return equipoServiceImpl.insertar(equipo);
	}
	
	//POST
	@PostMapping("/equipo")
	public boolean actualizarEquipo (@RequestBody EquipoModel equipo) {
		log.info("ini: actualizar Equipo()");
		
		log.debug("datos equipo:" + equipo.toString());
		return equipoServiceImpl.actualizar(equipo);
	}
}

/*
 * EJEMPLO
 {
    "nombreEquipo": "Sporting Cristal",
    "anioFundacion": "1960-02-15",
    "aniosExistencia": 60,
    "imagenEscudo": "imagen1",
    "duenioActual": "Carlos",
    "patrocinadorOficial": "Adidas"
}
 */
