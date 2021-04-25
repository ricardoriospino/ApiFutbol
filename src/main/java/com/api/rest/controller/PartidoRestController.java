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

import com.api.model.entity.PartidoModel;
import com.api.rest.dto.PartidoFullDTO;
import com.api.service.impl.PartidoServiceImpl;

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
	public boolean agregarPartido(@Valid @RequestBody PartidoModel partido) {
		log.info("ini: agregarPartido()");
		
		log.debug("datos partido:" + partido.toString());
		return partidoServiceImpl.insertarPartido(partido);
		
	}
	// --------------------------------------------------------------------
	
	//POST
	//http://localhost:8090/apiFutbol/partido
	@PostMapping("/partido")
	public boolean actualizarPartido(@RequestBody PartidoModel partido) {
		log.info("ini: actualizarPartido()");
				
		log.debug("datos partido:" + partido.toString());
		return partidoServiceImpl.actualizar(partido);
	}
	
	// --------------------------------------------------------------------
	//DELETE
	//http://localhost:8090/apiFutbol/borrarPartido/1
	@DeleteMapping ("/borrarPartido/{idPartido}")
	public boolean borrarPartido (@PathVariable("idPartido") int id ) {
		
		log.info("ini: borrarPartido()");
		log.debug("id:" +  id );
		
		return partidoServiceImpl.borrar(id);
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
	public List<PartidoModel> obtenerPartidosPorArbitro(@PathVariable("pnombreArbitro")String nombre){
		
		log.info("ini: obtenerPartidosPorArbitro()");
		
		log.debug("nombre:" +  nombre );
		return partidoServiceImpl.obtenerPartidosPorArbitro(nombre);
		
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
	public PartidoFullDTO obtenerPartidoFullPorCodigo(@PathVariable("pcodigoPartido")String codigoPartido) {
		
		log.info("ini: obtenerPartidoFullPorCodigo()");
		
		log.debug("Codigo Partido:" +  codigoPartido  );
		
		return partidoServiceImpl.obtenerPartidoFporCodigo(codigoPartido);
	}
	
	// -------------------------------------------------------------------------
	
	//Lista partidos por mes y año 
	
	//http://localhost:8090/apiFutbol/listaPartido/04/2021
	@GetMapping ("/listaPartido/{mes}/{anio}")
	public List<PartidoModel> obtenerPartidosPorMesyAño (@PathVariable("mes")String mes , @PathVariable ("anio")String anio){
		
		log.info("ini: obtenerPartidosPorMesyAño()");
		
		log.debug("mes:" + mes + "año : " + anio  );
		
		return partidoServiceImpl.obtenerPartidoPorAnioyMes(mes, anio);
	}
	
	
}
