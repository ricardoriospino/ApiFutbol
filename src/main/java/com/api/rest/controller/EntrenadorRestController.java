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
	public boolean agregarEntrenador(@Valid @RequestBody EntrenadorModel entrenador) {
		log.info("ini: agregarEntrenador()");
		
		log.debug("datos entrenador:" + entrenador.toString());
		return entrenadorServiceImpl.insertar(entrenador);
	}
	
	//-------------------------------------------------------------------------
	
	// http://localhost:8090/apiEntrenador/entrenador
	//POST
	@PostMapping("/entrenador")
	public boolean actualizarEntrenador(@RequestBody EntrenadorModel entrenador) {
		log.info("ini: actualizar Entrenador()");
		
		log.debug("datos entrenador:" + entrenador.toString());
		return entrenadorServiceImpl.actualizar(entrenador);
	}
	
	// ----------------------------------------------------------------------
	
	//DELETE
	// http://localhost:8090/apiEntrenador/borrarEntrenador/3/Soso
	@DeleteMapping ("/borrarEntrenador/{idEntrenador}/{nombreEntrenador}")
	public boolean borrarEntrenador (@PathVariable("idEntrenador") int id ,@PathVariable("nombreEntrenador") String nombre ) {
		
		log.info("ini: borrarEntrenador()");
		log.debug("id:" +  id + "nombre: " + nombre );
		
		return entrenadorServiceImpl.borrar(nombre, id);
	}
	
	// -------------------------------------------------------------------------
	//GET SIN PARAMETROS SIN PAGINACION 
	// http://localhost:8090/apiEntrenador/entrenadores
	@GetMapping("/entrenadores")
	public List<EntrenadorModel> obtenerEntrenadores(){
		log.info("ini: obtenerEntrenadores() ");
		
		return entrenadorServiceImpl.obtenerEntrenadores();
	}
	
	// --------------------------------------------------------------------------
	//GET CON PAGINACION Y TAMAÑO
	// http://localhost:8090/apiEntrenador/entrenadoresP?page=0&size=3
	@GetMapping ("/entrenadoresP")
	public List<EntrenadorModel> obtenerEntrenadoresPaginacion(Pageable paginacion){
		log.info("ini: obtenerEntrenadoresPaginacion()");
		
		return entrenadorServiceImpl.obtenerEntrenadoresPaginacion(paginacion);
	}
	
	// --------------------------------------------------------------------------
	
	// http://localhost:8090/apiEntrenador/entrenadores/Cueto/Paraguay
	// GET CON PARAMETROS 
	@GetMapping ("/entrenadores/{pnombre}/{pnacionalidad}")
	public  EntrenadorModel obtenerEntrenadorPorNombreyNacionalidad (@PathVariable("pnombre")String nombre, @PathVariable("pnacionalidad") String nacionalidad ) {
		
		log.info("ini: obtenerEntrenadorPorNombreyNacionalidad()");
		
		log.debug("nombre:" +  nombre + ", nacionalidad : " + nacionalidad  );
		return  entrenadorServiceImpl.obtenerEntrenadorPorNombreyNacionalidad(nombre, nacionalidad);
	}
	
}
