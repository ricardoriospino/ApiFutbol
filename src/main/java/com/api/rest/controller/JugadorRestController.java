package com.api.rest.controller;

import java.util.List;

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
	
	// ---------------------------------------------------------------------
	
	//http://localhost:8090/apiJugador/jugador
	//POST
	@PostMapping("/jugador")
	public boolean actualizarJugador(@RequestBody JugadorModel jugador) {
		log.info("ini: actualizarJugador()");
			
		log.debug("datos jugador:" + jugador.toString());
		return jugadorServiceImpl.actualizar(jugador);
	}
	
	
	//-----------------------------------------------------------------------
	
	//DELETE
	//http://localhost:8090/apiJugador/borrarJugador/12
	@DeleteMapping ("/borrarJugador/{idJugador}")
	public boolean borrarJugador (@PathVariable("idJugador") int id ) {
		
		log.info("ini: borrarJugador()");
		log.debug("id:" +  id );
		
		return jugadorServiceImpl.borrar(id);
	}
	
	// --------------------------------------------------------------------
	
	//GET SIN PARAMETROS SIN PAGINACION 
	// http://localhost:8090/apiJugador/jugadores
	@GetMapping("/jugadores")
	public List<JugadorModel> obtenerJugadores(){
		log.info("ini: obtenerJugadores() ");
			
		return jugadorServiceImpl.obtenerJugadores();
	}
		
	// -------------------------------------------------------------
	//GET CON PAGINACION Y TAMAÑO
	// http://localhost:8090/apiJugador/jugadoresP?page=0&size=3
	@GetMapping ("/jugadoresP")
	public List<JugadorModel> obtenerJugadoresPaginacion(Pageable paginacion){
		log.info("ini: obtenerJugadoresPaginacion()");
			
		return jugadorServiceImpl.obtenerJugadoresPaginacion(paginacion);
	}
	
	// -----------------------------------------------------------------
	
	// GET CON PARAMETROS 
	// http://localhost:8090/apiJugador/jugador/7/Argentina
	@GetMapping ("/jugador/{pdorsal}/{pnacionalidad}")
	public  JugadorModel obtenerJugadorPorDorsalyNacionalidad (@PathVariable("pdorsal")int dorsal , @PathVariable("pnacionalidad") String nacionalidad  ) {
						
		log.info("ini: obtenerEstadioPorNombre()");
						
		log.debug("dorsal:" +  dorsal + " ,nacionalidad : " + nacionalidad);
		
		return  jugadorServiceImpl.obtenerJugadorPorDorsalyNacionalidad(dorsal, nacionalidad);
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
