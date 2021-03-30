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
	
	// ----------------------------------------------------------------------
	
	// POST
	// http://localhost:8090/apiPosiciones/posiciones
	@PostMapping("/posiciones")
	public boolean actualizarPosiciones(@RequestBody PosicionesModel posiciones) {
		log.info("ini: actualizarPosiciones()");
				
		log.debug("datos Posiciones:" + posiciones.toString());
		return posicionesServiceImpl.actualizar(posiciones);
	}
	
	//---------------------------------------------------------------------
	
	//DELETE 
	// http://localhost:8090/apiPosiciones/borrarPosicion/10
	@DeleteMapping ("/borrarPosicion/{idPosicion}")
	public boolean borrarPosicion (@PathVariable("idPosicion") int id  ) {
		
		log.info("ini: borrarPosicion()");
		log.debug("id:" +  id );
		
		return posicionesServiceImpl.borrar(id);
	}
	
	// -------------------------------------------------------------------
	//GET SIN PARAMETROS SIN PAGINACION 
	// http://localhost:8090/apiPosiciones/posiciones
	@GetMapping("/posiciones")
	public List<PosicionesModel> obtenerPosiciones(){
		log.info("ini: obtenerPosiciones() ");
			
		return posicionesServiceImpl.obtenerPosiciones();
	}
	
	// ------------------------------------------------------------------------
	
	//GET CON PAGINACION Y TAMAÑO
	// http://localhost:8090/apiPosiciones/posicionesP?page=0&size=3
	@GetMapping ("/posicionesP")
	public List<PosicionesModel> obtenerPosicionesPaginacion(Pageable paginacion){
		log.info("ini: obtenerPosicionesPaginacion()");
			
		return posicionesServiceImpl.obtenerPosicionesPaginacion(paginacion);
	}
	
	// ---------------------------------------------------------------------------
	
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
