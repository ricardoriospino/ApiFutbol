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

import com.api.model.entity.EquipoJugadorModel;
import com.api.model.entity.FaltaModel;
import com.api.model.entity.GolModel;
import com.api.model.entity.JugadorModel;
import com.api.rest.dto.JugadorFullDTO;
import com.api.rest.dto.JugadorGolFaltaFullDTO;
import com.api.rest.dto.JugadorGolFullDTO;
import com.api.service.impl.JugadorServiceImpl;

@RestController
@RequestMapping("/apiFutbol")
public class JugadorRestController {
	private static final Logger log = LogManager.getLogger(JugadorRestController.class);
	
	@Autowired
	@Qualifier("jugadorServiceImpl")
	private JugadorServiceImpl jugadorServiceImpl;
	
	// http://localhost:8090/apiFutbol/jugador
	
	//PUT
	@PutMapping("/jugador")
	public boolean agregarJugador(@Valid @RequestBody JugadorModel jugador) {
		log.info("ini: agregarJugador()");
		
		log.debug("datos jugador:" + jugador.toString());
		return jugadorServiceImpl.insertar(jugador);
	}
	
	// -------------------------------------------------------------
	//PUT
	
	// http://localhost:8090/apiFutbol/jugador-equipo
	
	@PutMapping("/jugador-equipo")
	public boolean agregarJugadorEquipo(@Valid @RequestBody EquipoJugadorModel jugadorEquipo) {
		log.info("ini: agregarJugadorEquipo()");
			
		log.debug("datos jugador equipo:" + jugadorEquipo.toString());
		return jugadorServiceImpl.insertarJugadorEquipo(jugadorEquipo);
	}
	
	//---------------------------------------------------------------------
	//PUT
	
	// http://localhost:8090/apiFutbol/jugador-falta
	@PutMapping("/jugador-falta")
	public boolean agregarJugadorFalta(@Valid @RequestBody FaltaModel falta) {
		log.info("ini: agregarJugadorFalta()");
			
		log.debug("datos jugador falta:" + falta.toString());
		return jugadorServiceImpl.insertarFaltaJugadorPartido(falta);
	}
	
	// -------------------------------------------------------------------
	// http://localhost:8090/apiFutbol/jugador-gol
	@PutMapping("/jugador-gol")
	public boolean agregarJugadorGol(@Valid @RequestBody GolModel gol) {
		log.info("ini: agregarJugadorGol()");
			
		log.debug("datos jugador gol:" + gol.toString());
		return jugadorServiceImpl.insertarGolJugadorPartido(gol);
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
	//http://localhost:8090/apiFutbol/borrarJugador/12
	@DeleteMapping ("/borrarJugador/{idJugador}")
	public boolean borrarJugador (@PathVariable("idJugador") int id ) {
		
		log.info("ini: borrarJugador()");
		log.debug("id:" +  id );
		
		return jugadorServiceImpl.borrar(id);
	}
	
	// --------------------------------------------------------------------
	
	//GET SIN PARAMETROS SIN PAGINACION 
	// http://localhost:8090/apiFutbol/jugadores
	@GetMapping("/jugadores")
	public List<JugadorModel> obtenerJugadores(){
		log.info("ini: obtenerJugadores() ");
			
		return jugadorServiceImpl.obtenerJugadores();
	}
		
	// -------------------------------------------------------------
	//GET CON PAGINACION Y TAMAÑO
	// http://localhost:8090/apiFutbol/jugadoresP?page=0&size=3
	@GetMapping ("/jugadoresP")
	public List<JugadorModel> obtenerJugadoresPaginacion(Pageable paginacion){
		log.info("ini: obtenerJugadoresPaginacion()");
			
		return jugadorServiceImpl.obtenerJugadoresPaginacion(paginacion);
	}
	
	// -----------------------------------------------------------------
	
	// GET CON PARAMETROS 
	// http://localhost:8090/apiFutbol/jugador/7/Argentina
	@GetMapping ("/jugador/{pdorsal}/{pnacionalidad}")
	public  JugadorModel obtenerJugadorPorDorsalyNacionalidad (@PathVariable("pdorsal")int dorsal , @PathVariable("pnacionalidad") String nacionalidad  ) {
						
		log.info("ini: obtenerEstadioPorNombre()");
						
		log.debug("dorsal:" +  dorsal + " ,nacionalidad : " + nacionalidad);
		
		return  jugadorServiceImpl.obtenerJugadorPorDorsalyNacionalidad(dorsal, nacionalidad);
	}
	
	//-------------------------------------------------------------------------------
	
	//GET CON PARAMETROS FULL
	
	//http://localhost:8090/apiFutbol/jugador/JU0001
	@GetMapping ("/jugador/{pcodigoJugador}")
	public JugadorFullDTO obtenerJugadorPorCodigoFull (@PathVariable("pcodigoJugador")String codigoJugador) {
		
		log.info("ini: obtenerJugadorPorCodigoFull()");
		
		log.debug("Codigo jugador:" +  codigoJugador  );
		
		return jugadorServiceImpl.obtenerJugadorFporCodigo(codigoJugador);
	}
	
	// ----------------------------------------------------------------------------------
	
	//GET JUGADOR FALTA FULL
	//http://localhost:8090/apiFutbol/jugadorNombre/Cazulo
	@GetMapping ("/jugadorNombre/{pnombreJugador}")
	public JugadorFullDTO obtenerJugadorPorNombreFaltaFull (@PathVariable("pnombreJugador")String nombreJugador) {
		
		log.info("ini: obtenerJugadorPorNombreFaltaFull()");
		
		log.debug("nombre jugador:" +  nombreJugador  );
		
		return jugadorServiceImpl.obtenerJugadorFporNombre(nombreJugador);
	}
	
	// -----------------------------------------------------------------------------------
	
	//GET JUGADOR GOL FULL
	
	//http://localhost:8090/apiFutbol/jugadorNombreGol/Cazulo
	@GetMapping("jugadorNombreGol/{pnombreJugador}")
	public JugadorGolFullDTO obtenerJugadorPorNombreGolFull (@PathVariable("pnombreJugador")String nombreJugador) {
		
		log.info("ini: obtenerJugadorPorNombreGolFull()");
		
		log.debug("nombre jugador:" +  nombreJugador  );
		
		return jugadorServiceImpl.obtenerJugadorFporNombreGol(nombreJugador);
	}
	
	//-------------------------------------------------------------------------
	//GET JUGADOR GOL Y FALTA FULL
	//http://localhost:8090/apiFutbol/jugadorNombreGolyFalta/Cazulo
	@GetMapping("jugadorNombreGolyFalta/{pnombreJugador}")
	public JugadorGolFaltaFullDTO obtenerJugadorPorNombreGolyFaltaFull(@PathVariable("pnombreJugador")String nombreJugador) {
	
		log.info("ini: obtenerJugadorPorNombreGolyFaltaFull()");
		
		log.debug("nombre jugador:" +  nombreJugador  );
		
		return jugadorServiceImpl.obtenerJugadorFullGolyFaltaPorNombre(nombreJugador);
		
	}
	
}
