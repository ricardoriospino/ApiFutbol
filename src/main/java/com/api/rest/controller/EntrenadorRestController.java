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
import com.api.model.entity.EquipoEntrenadorModel;
import com.api.rest.dto.EntrenadorFullDTO;
import com.api.service.impl.EntrenadorServiceImpl;

@RestController
@RequestMapping("/apiFutbol")
public class EntrenadorRestController {
	private static final Logger log = LogManager.getLogger(EntrenadorRestController.class);

	@Autowired
	@Qualifier("entrenadorServiceImpl")
	private EntrenadorServiceImpl entrenadorServiceImpl;
	
	// http://localhost:8090/apiFutbol/entrenador
	// PUT
	@PutMapping("/entrenador")
	public boolean agregarEntrenador(@Valid @RequestBody EntrenadorModel entrenador) {
		log.info("ini: agregarEntrenador()");
		
		log.debug("datos entrenador:" + entrenador.toString());
		return entrenadorServiceImpl.insertar(entrenador);
	}
	
	//-----------------------------------------------------------------
	// http://localhost:8090/apiFutbol/entrenador-equipo
		// PUT
	@PutMapping("/entrenador-equipo")
	public boolean agregarEntrenadorEquipo(@Valid @RequestBody EquipoEntrenadorModel entrenadorEquipo) {
		log.info("ini: agregarEntrenadorEquipo()");
			
		log.debug("datos entrenador equipo:" + entrenadorEquipo.toString());
		return entrenadorServiceImpl.insertarEntrenadorEquipo(entrenadorEquipo);
	}
	
	//-------------------------------------------------------------------------
	
	// http://localhost:8090/apiFutbol/entrenador
	//POST
	@PostMapping("/entrenador")
	public boolean actualizarEntrenador(@RequestBody EntrenadorModel entrenador) {
		log.info("ini: actualizar Entrenador()");
		
		log.debug("datos entrenador:" + entrenador.toString());
		return entrenadorServiceImpl.actualizar(entrenador);
	}
	
	// ----------------------------------------------------------------------
	
	//DELETE
	// http://localhost:8090/apiFutbol/borrarEntrenador/3/Soso/38
	@DeleteMapping ("/borrarEntrenador/{idEntrenador}/{nombreEntrenador}/{partidosJugados}")
	public boolean borrarEntrenador (@PathVariable("idEntrenador") int id ,
			@PathVariable("nombreEntrenador") String nombre ,
			@PathVariable("partidosJugados") int partidosJugados	) {
		
		log.info("ini: borrarEntrenador()");
		log.debug("id:" +  id + "nombre: " + nombre );
		
		return entrenadorServiceImpl.borrar(nombre, id, partidosJugados);
	}
	
	// -------------------------------------------------------------------------
	//GET SIN PARAMETROS SIN PAGINACION 
	// http://localhost:8090/apiFutbol/entrenadores
	@GetMapping("/entrenadores")
	public List<EntrenadorModel> obtenerEntrenadores(){
		log.info("ini: obtenerEntrenadores() ");
		
		return entrenadorServiceImpl.obtenerEntrenadores();
	}
	
	// --------------------------------------------------------------------------
	//GET CON PAGINACION Y TAMAÑO
	// http://localhost:8090/apiFutbol/entrenadoresP?page=0&size=3
	@GetMapping ("/entrenadoresP")
	public List<EntrenadorModel> obtenerEntrenadoresPaginacion(Pageable paginacion){
		log.info("ini: obtenerEntrenadoresPaginacion()");
		
		return entrenadorServiceImpl.obtenerEntrenadoresPaginacion(paginacion);
	}
	
	// --------------------------------------------------------------------------
	
	// http://localhost:8090/apiFutbol/entrenadores/Teddy Cardama/Peru
	// GET CON PARAMETROS 
	@GetMapping ("/entrenadores/{pnombre}/{pnacionalidad}")
	public  EntrenadorModel obtenerEntrenadorPorNombreyNacionalidad (@PathVariable("pnombre")String nombre, @PathVariable("pnacionalidad") String nacionalidad ) {
		
		log.info("ini: obtenerEntrenadorPorNombreyNacionalidad()");
		
		log.debug("nombre:" +  nombre + ", nacionalidad : " + nacionalidad  );
		return  entrenadorServiceImpl.obtenerEntrenadorPorNombreyNacionalidad(nombre, nacionalidad);
	}
	
	//------------------------------------------------------------------
	//Entrenador x nacionalidad
	//http://localhost:8090/apiFutbol/entrenadoresN/Paraguay
	@GetMapping ("/entrenadoresN/{pnacionalidad}")
	public  List<EntrenadorModel> obtenerEntrenadorPorNacionalidad ( @PathVariable("pnacionalidad") String nacionalidad ) {
		
		log.info("ini: obtenerEntrenadorPorNacionalidad()");
		
		log.debug( " nacionalidad : " + nacionalidad  );
		
		return entrenadorServiceImpl.obtenerEntrenadorPorNacionalidad(nacionalidad);
		
	}
		
	//---------------------------------------------------------------------------
	
	//http://localhost:8090/apiFutbol/entrenadores/EN001
	@GetMapping ("/entrenadores/{pcodigoEntrenador}")
	public  EntrenadorFullDTO obtenerEntrenadorPorCodigoFull(@PathVariable("pcodigoEntrenador")String codigoEntrenador ) {
		
		log.info("ini: obtenerEntrenadorPorCodigoFull()");
		
		log.debug("Codigo entrenador:" +  codigoEntrenador  );
		return  entrenadorServiceImpl.obtenerEntrenadorFporCodigo(codigoEntrenador);
	}
}
