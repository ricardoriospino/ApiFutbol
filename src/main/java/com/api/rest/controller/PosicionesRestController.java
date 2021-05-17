package com.api.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/apiFutbol")
public class PosicionesRestController {
	private static final Logger log = LogManager.getLogger(PosicionesRestController.class);
	
	@Autowired
	@Qualifier("posicionesServiceImpl")
	private PosicionesServiceImpl posicionesServiceImpl;
	
	// http://localhost:8090/apiFutbol/posiciones

	// PUT
	@PutMapping("/posiciones")
	public ResponseEntity<?> agregarPosiciones(@Valid @RequestBody PosicionesModel posiciones) {
		log.info("ini: agregarPosiciones()");
			
		log.debug("datos Posiciones:" + posiciones.toString());
		boolean flag =  posicionesServiceImpl.insertar(posiciones);
		
		if(flag)
			return new ResponseEntity<>(HttpStatus.OK);
		else		
			return new ResponseEntity<>(false,HttpStatus.CONFLICT);
	}
	
	// ----------------------------------------------------------------------
	
	// POST
	// http://localhost:8090/apiFutbol/posiciones
	@PostMapping("/posiciones")
	public ResponseEntity<?> actualizarPosiciones(@RequestBody PosicionesModel posiciones) {
		log.info("ini: actualizarPosiciones()");
				
		log.debug("datos Posiciones:" + posiciones.toString());
		boolean flag =  posicionesServiceImpl.actualizar(posiciones);
		
		if(flag)
			return new ResponseEntity<>(HttpStatus.OK);
		else		
			return new ResponseEntity<>(false,HttpStatus.CONFLICT);
	}
	
	//---------------------------------------------------------------------
	
	//DELETE 
	// http://localhost:8090/apiFutbol/borrarPosicion/10
	@DeleteMapping ("/borrarPosicion/{idPosicion}")
	public ResponseEntity<?> borrarPosicion (@PathVariable("idPosicion") int id  ) {
		
		log.info("ini: borrarPosicion()");
		log.debug("id:" +  id );
		
		boolean flag =  posicionesServiceImpl.borrar(id);
		
		if(flag)
			return new ResponseEntity<>(HttpStatus.OK);
		else		
			return new ResponseEntity<>(false,HttpStatus.CONFLICT);
	}
	
	// -------------------------------------------------------------------
	//GET SIN PARAMETROS SIN PAGINACION 
	// http://localhost:8090/apiFutbol/posiciones
	@GetMapping("/posiciones")
	public List<PosicionesModel> obtenerPosiciones(){
		log.info("ini: obtenerPosiciones() ");
			
		return posicionesServiceImpl.obtenerPosiciones();
	}
	
	// ------------------------------------------------------------------------
	
	//GET CON PAGINACION Y TAMAÑO
	// http://localhost:8090/apiFutbol/posicionesP?page=0&size=3
	@GetMapping ("/posicionesP")
	public List<PosicionesModel> obtenerPosicionesPaginacion(Pageable paginacion){
		log.info("ini: obtenerPosicionesPaginacion()");
			
		return posicionesServiceImpl.obtenerPosicionesPaginacion(paginacion);
	}
	
	// ---------------------------------------------------------------------------
	
	
}
