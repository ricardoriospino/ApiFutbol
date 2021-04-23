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


import com.api.model.entity.EstadioModel;
import com.api.rest.dto.EstadioFullDTO;
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
	public boolean agregarEstadio(@Valid @RequestBody EstadioModel estadio) {
		log.info("ini: agregarEstadio()");
		
		log.debug("datos estadio:" + estadio.toString());
		return estadioServiceImpl.insertar(estadio);
	
	}
	
	// ---------------------------------------------------------------------
	
	// http://localhost:8090/apiEstadio/estadio
	//POST
	@PostMapping("/estadio")
	public boolean actualizarEstadio(@RequestBody EstadioModel estadio) {
		log.info("ini: actualizarEstadio()");
		
		log.debug("datos estadio:" + estadio.toString());
		return estadioServiceImpl.actualizar(estadio);
	
	}
	
	// -------------------------------------------------------------
	
	//DELETE
	//http://localhost:8090/apiEstadio/borrarEstadio/1
	@DeleteMapping ("/borrarEstadio/{idEstadio}/{idEquipo}")
	public boolean borrarEstadio (@PathVariable("idEstadio") int id ) {
		
		log.info("ini: borrarEstadio()");
		log.debug("id:" +  id );
		
		return estadioServiceImpl.borrar(id);
	}
	
	// ------------------------------------------------------------------
	//GET SIN PARAMETROS SIN PAGINACION 
	//http://localhost:8090/apiEstadio/estadios
	@GetMapping("/estadios")
	public List<EstadioModel> obtenerEstadios(){
		log.info("ini: obtenerEstadios() ");
		
		return estadioServiceImpl.obtenerEstadios();
	}
	
	// -------------------------------------------------------------
	
	//GET CON PAGINACION Y TAMAÑO
	// http://localhost:8090/apiEstadio/estadiosP?page=0&size=3
	
	@GetMapping ("/estadiosP")
	public List<EstadioModel> obtenerEstadiosPaginacion(Pageable paginacion){
		log.info("ini: obtenerEstadiosPaginacion()");
		
		return estadioServiceImpl.obtenerEstadiosPaginacion(paginacion);
	}
	
	// --------------------------------------------------------------
	
	// GET CON PARAMETROS 
	// http://localhost:8090/apiEstadio/estadior/Nacional
	@GetMapping ("/estadior/{pnombre}")
	public  EstadioModel obtenerEstadioPorNombre (@PathVariable("pnombre")String nombre ) {
					
		log.info("ini: obtenerEstadioPorNombre()");
					
		log.debug("nombre:" +  nombre );
		return  estadioServiceImpl.obtenerEstadioPorNombre(nombre);
	}
	
	// -----------------------------------------------------------------------------------
	//http://localhost:8090/apiEstadio/estadiop/ES001
	@GetMapping ("/estadiop/{pcodigo}")
	public EstadioFullDTO obtenerEstadioPorCodigoFull (@PathVariable("pcodigo")String codigoEstadio ) {
		
		log.info("ini: obtenerEstadioPorCodigoFull()");
		log.debug("Codigo estadio:" +  codigoEstadio  );
		return estadioServiceImpl.obtenerEstadioPorFcodigo(codigoEstadio);
	}

}
