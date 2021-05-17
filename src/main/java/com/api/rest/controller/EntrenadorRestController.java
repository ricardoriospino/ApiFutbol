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

import com.api.model.entity.EntrenadorModel;
import com.api.model.entity.EquipoEntrenadorModel;
import com.api.model.entity.ResponseErrorModel;
import com.api.respuesta.model.RespuestaListaEntrenador;
import com.api.service.impl.EntrenadorServiceImpl;
import com.api.util.MensajeError;

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
	public ResponseEntity<?> agregarEntrenador(@Valid @RequestBody EntrenadorModel entrenador) {
		log.info("ini: agregarEntrenador()");
		
		log.debug("datos entrenador:" + entrenador.toString());
		
		boolean flag = entrenadorServiceImpl.insertar(entrenador);
		
		if(flag)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
	}
	
	//-----------------------------------------------------------------
	// http://localhost:8090/apiFutbol/entrenador-equipo
		// PUT
	@PutMapping("/entrenador-equipo")
	public ResponseEntity<?> agregarEntrenadorEquipo(@Valid @RequestBody EquipoEntrenadorModel entrenadorEquipo) {
		log.info("ini: agregarEntrenadorEquipo()");
			
		log.debug("datos entrenador equipo:" + entrenadorEquipo.toString());
		
		boolean flag = entrenadorServiceImpl.insertarEntrenadorEquipo(entrenadorEquipo);
		
		if(flag)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
		
		
	}
	
	//-------------------------------------------------------------------------
	
	// http://localhost:8090/apiFutbol/entrenador
	//POST
	@PostMapping("/entrenador")
	public ResponseEntity<?> actualizarEntrenador(@RequestBody EntrenadorModel entrenador) {
		log.info("ini: actualizar Entrenador()");
		
		log.debug("datos entrenador:" + entrenador.toString());
		boolean flag = entrenadorServiceImpl.actualizar(entrenador);
		
		if(flag)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
		
		
	}
	
	// ----------------------------------------------------------------------
	
	//DELETE
	// http://localhost:8090/apiFutbol/borrarEntrenador/3/Soso/38
	@DeleteMapping ("/borrarEntrenador/{idEntrenador}/{nombreEntrenador}/{partidosJugados}")
	public ResponseEntity<?> borrarEntrenador (@PathVariable("idEntrenador") int id ,
			@PathVariable("nombreEntrenador") String nombre ,
			@PathVariable("partidosJugados") int partidosJugados	) {
		
		log.info("ini: borrarEntrenador()");
		log.debug("id:" +  id + "nombre: " + nombre );
		
		boolean flag = entrenadorServiceImpl.borrar(nombre, id, partidosJugados);
		
		if(flag)
			return new ResponseEntity<>(HttpStatus.OK);
		else		
			return new ResponseEntity<>(false,HttpStatus.CONFLICT);
		
		
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
	public  Object obtenerEntrenadorPorNombreyNacionalidad (@PathVariable("pnombre")String nombre, @PathVariable("pnacionalidad") String nacionalidad ) {
		
		log.info("ini: obtenerEntrenadorPorNombreyNacionalidad()");
		
		log.debug("nombre:" +  nombre + ", nacionalidad : " + nacionalidad  );

		return  entrenadorServiceImpl.obtenerEntrenadorPorNombreyNacionalidad(nombre, nacionalidad);
	}
	
	//------------------------------------------------------------------
	//Entrenador x nacionalidad
	//http://localhost:8090/apiFutbol/entrenadoresN/Paraguay
	@GetMapping ("/entrenadoresN/{pnacionalidad}")
	public  Object obtenerEntrenadorPorNacionalidad ( @PathVariable("pnacionalidad") String nacionalidad ) {
		
		log.info("ini: obtenerEntrenadorPorNacionalidad()");

		log.debug( " nacionalidad : " + nacionalidad  );
	
		RespuestaListaEntrenador respuesta  = new RespuestaListaEntrenador(entrenadorServiceImpl.obtenerEntrenadorPorNacionalidad(nacionalidad));
			
		if(respuesta != null && respuesta.getListaEntrenadores().size()>0  ) {
			
			return respuesta;	
		}else {
			
			return new ResponseErrorModel(MensajeError.COD_OOO2, MensajeError.Mensaje_OOO2);			
		}
	
	}
		
	//---------------------------------------------------------------------------
	
	//http://localhost:8090/apiFutbol/entrenadores/EN001
	@GetMapping ("/entrenadores/{pcodigoEntrenador}")
	public  Object obtenerEntrenadorPorCodigoFull(@PathVariable("pcodigoEntrenador")String codigoEntrenador ) {
		
		log.info("ini: obtenerEntrenadorPorCodigoFull()");
		
		log.debug("Codigo entrenador:" +  codigoEntrenador  );
		return  entrenadorServiceImpl.obtenerEntrenadorFporCodigo(codigoEntrenador);
	}
}
