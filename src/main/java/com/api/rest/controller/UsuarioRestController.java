package com.api.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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


import com.api.model.entity.UsuarioModel;
import com.api.service.impl.UsuarioServiceImpl;

@RestController
@RequestMapping("/apiFutbol")
public class UsuarioRestController {
	private static final Logger log = LogManager.getLogger(UsuarioRestController.class);
	
	@Autowired
	@Qualifier("usuarioServiceImpl")
	private UsuarioServiceImpl usuarioServiceImpl;
	
	
	//http://localhost:8090/apiFutbol/usuario
	//PUT
	@PutMapping("/usuario")
	public ResponseEntity<?>agregarUsuario(@Valid @RequestBody UsuarioModel usuario){
		log.info("ini: agregarUsuario");
		
		log.debug("datos usuario" + usuario.toString());
		
		int estado = usuarioServiceImpl.insertar(usuario);
		
		if(estado == 2)		
			return new ResponseEntity<>(HttpStatus.OK);	
		else if (estado == 1)		
			return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
	}
	
	// ----------------------------------------------------------------------------------
	
	//http://localhost:8090/apiFutbol/actualizarUsuario
	//POST
	@PostMapping("/actualizarUsuario")
	public ResponseEntity<?>actualizarUsuario(@Valid @RequestBody UsuarioModel usuario){
		log.info("ini: actualizarUsuario");
		
		log.debug("datos usuario" + usuario.toString());
		
		boolean flag = usuarioServiceImpl.actualizar(usuario);
		
		if(flag)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
		
	}
	
	// -----------------------------------------------------------------------------------
	
	//http://localhost:8090/apiFutbol/borrarUsuario/3
	//DELETE
	@DeleteMapping ("/borrarUsuario/{idBorrar}")
	public ResponseEntity<?> borrarUsuario(@PathVariable("idBorrar")int id){
		log.info("ini: borrarUsuario");
		
		log.debug("id:" + id);
		
		boolean flag = usuarioServiceImpl.borrar(id);
		
		if(flag)
			return new ResponseEntity<>(HttpStatus.OK);
		else		
			return new ResponseEntity<>(false,HttpStatus.CONFLICT);
		
	}
	
	// -------------------------------------------------------------------------
		
	// http://localhost:8090/apiFutbol/usuarios
	@GetMapping("/usuarios")
	public List<UsuarioModel> obtenerUsuarios(){
		log.info("ini: obtenerUsuarios() ");
		
		return usuarioServiceImpl.obtenerUsuarios();
		
	}
	
	// ----------------------------------------------------------------------------------

	//GET CON PARAMETROS 
	// http://localhost:8090/apiFutbol/usuariop/kevin
	@GetMapping("/usuariop/{pnombre}")
	public Object obtenerUsuarioPorNombre (@PathVariable("pnombre")String nombre) {
		
		log.info("ini: obtenerUsuarioPorNombre");
		
		log.debug("nombre: " + nombre);
		
		return usuarioServiceImpl.obtenerUsuarioPorNombre(nombre);
	}
	
	
	// ---------------------------------------------------------------------------------------
	// http://localhost:8090/apiFutbol/usuarioCodigo/USER003
	@GetMapping("/usuarioCodigo/{pcodigo}")
	public Object obtenerUsuarioPorCodigo (@PathVariable("pcodigo")String codigo) {
		
		log.info("ini: obtenerUsuarioPorCodigo");
		
		log.debug("codigo: " + codigo);
		
		return usuarioServiceImpl.obtenerUsuarioPorCodigoUsuario(codigo);
	}
	
	// --------------------------------------------------------------------------------------
	// http://localhost:8090/apiFutbol/usuarioN/kevin123
	@GetMapping("/usuarioN/{pnombreUsuario}")
	public Object obtenerUsuarioPorNombreUsuario (@PathVariable("pnombreUsuario")String nombreUsuario) {
			
		log.info("ini: obtenerUsuarioPorNombreUsuario");
		log.debug("nombre Usuario: " + nombreUsuario);
			
		return usuarioServiceImpl.obtenerUsuarioPorNombreUsuario(nombreUsuario);
	}
	
	// ----------------------------------------------------------------------------------------
	// http://localhost:8090/apiFutbol/usuarioNC
	@PostMapping("/usuarioNC")
	public ResponseEntity<?> obtenerUsuarioPorNombreyClave(@RequestBody UsuarioModel usuario) {
		
		log.info("ini: obtenerUsuarioPorNombreyClave");
		log.debug("datos usuario: " + usuario.toString());
		
		boolean flag = usuarioServiceImpl.obtenerUsuarioPorNombreUsuarioClave(usuario);
		
		if(flag)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);		
	}
	
	// ------------------------------------------------------------------------------------------
	
	//http://localhost:8090/apiFutbol/usuarioE/true
	@GetMapping("/usuarioE/{pisEnable}")
	public List<UsuarioModel> obtenerUsuariosPorActivo (@PathVariable("pisEnable")boolean Enable){
		
		log.info("ini: obtenerUsuariosPorActivo ");
		log.debug(Enable);
		
		
		
		return usuarioServiceImpl.obtenerUsuarioPorEnable(Enable);
	}
	
}
