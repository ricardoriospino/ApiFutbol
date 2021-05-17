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

import com.api.model.entity.PartidoModel;
import com.api.model.entity.ResponseErrorModel;
import com.api.respuesta.model.RespuestaListaPartido;
import com.api.service.impl.PartidoServiceImpl;
import com.api.util.MensajeError;

@RestController
@RequestMapping("/apiFutbol")
public class PartidoRestController {
	private static final Logger log = LogManager.getLogger(PartidoRestController.class);
	
	
	@Autowired
	@Qualifier("partidoServiceImpl")
	private PartidoServiceImpl partidoServiceImpl;
	
	//PUT
	//http://localhost:8090/apiFutbol/partido
	@PutMapping("/partido")
	public ResponseEntity<?> agregarPartido(@Valid @RequestBody PartidoModel partido) {
		log.info("ini: agregarPartido()");
		
		log.debug("datos partido:" + partido.toString());
		boolean flag = partidoServiceImpl.insertarPartido(partido);
		
		if(flag)
			return new ResponseEntity<>(HttpStatus.OK);
		else		
			return new ResponseEntity<>(false,HttpStatus.CONFLICT);
	}
	// --------------------------------------------------------------------
	
	//POST
	//http://localhost:8090/apiFutbol/partido
	@PostMapping("/partido")
	public ResponseEntity<?> actualizarPartido(@RequestBody PartidoModel partido) {
		log.info("ini: actualizarPartido()");
				
		log.debug("datos partido:" + partido.toString());
		boolean flag = partidoServiceImpl.actualizar(partido);
		
		if(flag)
			return new ResponseEntity<>(HttpStatus.OK);
		else		
			return new ResponseEntity<>(false,HttpStatus.CONFLICT);
	}
	
	// --------------------------------------------------------------------
	//DELETE
	//http://localhost:8090/apiFutbol/borrarPartido/1
	@DeleteMapping ("/borrarPartido/{idPartido}")
	public ResponseEntity<?> borrarPartido (@PathVariable("idPartido") int id ) {
		
		log.info("ini: borrarPartido()");
		log.debug("id:" +  id );
		
		boolean flag =  partidoServiceImpl.borrar(id);
		
		if(flag)
			return new ResponseEntity<>(HttpStatus.OK);
		else		
			return new ResponseEntity<>(false,HttpStatus.CONFLICT);
	}
	
	// ----------------------------------------------------------------------
	
	//GET SIN PARAMETROS SIN PAGINACION 
	// http://localhost:8090/apiFutbol/partidos
	@GetMapping("/partidos")
	public List<PartidoModel> obtenerPartidos(){
		log.info("ini: obtenerPartidos() ");
			
		return partidoServiceImpl.obtenerPartidos();
	}
	
	//------------------------------------------------------------------------
	
	//GET CON PARAMETROS
	//http://localhost:8090/apiFutbol/arbitro/Olivares
	@GetMapping ("/arbitro/{pnombreArbitro}")
	public Object obtenerPartidosPorArbitro(@PathVariable("pnombreArbitro")String nombre){
		
		log.info("ini: obtenerPartidosPorArbitro()");
		
		log.debug("nombre:" +  nombre );
		
		RespuestaListaPartido respuesta = new RespuestaListaPartido(partidoServiceImpl.obtenerPartidosPorArbitro(nombre));
		
		if (respuesta != null && respuesta.getListaPartidos().size()>0) {
			return respuesta;
		}else {
			return new ResponseErrorModel(MensajeError.COD_OOO10, MensajeError.Mensaje_OOO10);
		}
		
	}
	
	// -----------------------------------------------------------------------
	//GET CON PAGINACION Y TAMAÑO
	//http://localhost:8090/apiFutbol/partidosP?page=0&size=3
	@GetMapping ("/partidosP")
	public List<PartidoModel> obtenerPartidosPaginacion(Pageable paginacion){
		log.info("ini: obtenerPartidosPaginacion()");
		
		return partidoServiceImpl.obtenerPartidosPaginados(paginacion);
	}
	
	//-------------------------------------------------------------------
	
	//Partido FUll detallado goles y faltas
	//http://localhost:8090/apiFutbol/partidoFull/PA00001
	@GetMapping ("/partidoFull/{pcodigoPartido}")
	public Object obtenerPartidoFullPorCodigo(@PathVariable("pcodigoPartido")String codigoPartido) {
		
		log.info("ini: obtenerPartidoFullPorCodigo()");
		
		log.debug("Codigo Partido:" +  codigoPartido  );
		
		return partidoServiceImpl.obtenerPartidoFporCodigo(codigoPartido);
	}
	
	// -------------------------------------------------------------------------
	
	//Lista partidos por mes y año 
	
	//http://localhost:8090/apiFutbol/listaPartido/04/2021
	@GetMapping ("/listaPartido/{mes}/{anio}")
	public Object obtenerPartidosPorMesyAño (@PathVariable("mes")String mes , @PathVariable ("anio")String anio){
		
		log.info("ini: obtenerPartidosPorMesyAño()");
		
		log.debug("mes:" + mes + "año : " + anio  );
		
		RespuestaListaPartido respuesta = new RespuestaListaPartido( partidoServiceImpl.obtenerPartidoPorAnioyMes(mes, anio));
		
		if(respuesta.getListaPartidos() == null) {
			
			return new ResponseErrorModel(MensajeError.COD_OOO10 , MensajeError.Mensaje_OOO10);
			
		}else{
			return respuesta;
		}
	}
	
	
}
