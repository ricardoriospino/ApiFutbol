package com.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.api.jpa.entity.UsuarioJPA;
import com.api.jpa.repository.UsuarioRepository;
import com.api.model.entity.ResponseErrorModel;
import com.api.model.entity.UsuarioModel;
import com.api.service.UsuarioService;
import com.api.util.ConstanteUsuario;
import com.api.util.Convertidor;
import com.api.util.MensajeError;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements UsuarioService {
	private static final Logger log = LogManager.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	@Qualifier("repositorioUsuario")
	private UsuarioRepository repositorioUsuario;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;
	
	

	@Override
	public boolean insertar(UsuarioModel usuario) {
		
		try {
			
			UsuarioJPA codigoUsuario = repositorioUsuario.findByCodigoUsuario(usuario.getCodigoUsuario());
			
			UsuarioJPA nombreUsuario = repositorioUsuario.findByUsuario(usuario.getUsuario());
			
			if(codigoUsuario != null || nombreUsuario != null) {
				log.error("Codigo Ya existe");
				return false;
			}
			
			UsuarioJPA ultimoUsuarioCodigo = repositorioUsuario.findTopByOrderByIdUsuarioDesc();
			
			String codigo = ultimoUsuarioCodigo.getCodigoUsuario();
			
			String [] partes = codigo.split("R");
			
			String parte1 = partes[0];
			String parte2 = partes[1];
			
			int codigoNumero = Integer.parseInt(parte2);
			
			codigoNumero++;
			
			String codigoNuevo =ConstanteUsuario.USUARIO +"00"+codigoNumero  ;
			
			usuario.setCodigoUsuario(codigoNuevo);
			
			repositorioUsuario.save(new UsuarioJPA(usuario));
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al insertar " + e);
			return false;
		}
	}

	@Override
	public boolean actualizar(UsuarioModel usuario) {		

		try {
			
			UsuarioJPA usuarioJPA = repositorioUsuario.findByIdUsuario(usuario.getIdUsuario());
				
				if(usuarioJPA == null) {
					log.error("codigo no existe");
					return false;
				}

			repositorioUsuario.save(new UsuarioJPA(usuario));
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al insertar " + e);
			return false;
		}
		
	}

	@Override
	public boolean borrar(int id) {
		
		try {
			
			log.info("Borrar");
			Optional<UsuarioJPA> usuario = repositorioUsuario.findById(id);
			
			if(usuario.isPresent()) {
				repositorioUsuario.delete(usuario.get());
			}else {
				log.error ("No existe data para ese Id");
				return false;
			}
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al borrar " + e);
			return false;
		}
		
	}

	@Override
	public List<UsuarioModel> obtenerUsuarios() {
		
		return convertidor.convertirListaUsuarios(repositorioUsuario.findAll());
	}
	
	


	@Override
	public Object obtenerUsuarioPorNombre(String nombre) {
		
		UsuarioJPA usuarioJPA = repositorioUsuario.findByNombre(nombre);
		
		if(usuarioJPA == null) {
			log.error("No encontro datos nombre: " + nombre );
			
			return new ResponseErrorModel(MensajeError.COD_OOO12, MensajeError.Mensaje_OOO12);
		}else {
			UsuarioModel usuario = convertidor.convertirUsuarioModel(usuarioJPA);
			return usuario;
		}
	}

	@Override
	public Object obtenerUsuarioPorCodigoUsuario(String codigoUsuario) {
		
		UsuarioJPA usuarioJPA = repositorioUsuario.findByCodigoUsuario(codigoUsuario);
		
		if (usuarioJPA == null) {
			log.error("No encontro datos codigo usuario: " + codigoUsuario );
			
			return new ResponseErrorModel(MensajeError.COD_OOO12, MensajeError.Mensaje_OOO12);
		}else {
			UsuarioModel usuario = convertidor.convertirUsuarioModel(usuarioJPA);
			return usuario;
		}
	}

	@Override
	public Object obtenerUsuarioPorNombreUsuario(String nombreUsuario) {
		
		UsuarioJPA usuarioJPA = repositorioUsuario.findByUsuario(nombreUsuario);
		
		if (usuarioJPA == null) {
			log.error("No encontro datos nombre usuario: " + nombreUsuario );
			
			return new ResponseErrorModel(MensajeError.COD_OOO12, MensajeError.Mensaje_OOO12);
		}else {
			UsuarioModel usuario = convertidor.convertirUsuarioModel(usuarioJPA);
			return usuario;
		}
		
	}

	@Override
	public List<UsuarioModel> obtenerUsuarioPorEnable(boolean Enable) {
		
		List<UsuarioJPA> listaUsuarioJPA = repositorioUsuario.findByIsEnable(Enable);
		
		if (listaUsuarioJPA == null) {
			
			List<UsuarioModel> listaEntrenadorVacio = null;
			
			log.error("No encontro datos  usuario: " + Enable );
			
			return listaEntrenadorVacio;
			
		}else {
			
			List<UsuarioModel> listaUsuarios = convertidor.convertirListaUsuarios(listaUsuarioJPA);
			return listaUsuarios;
		}
		
	}

	@Override
	public boolean obtenerUsuarioPorNombreUsuarioClave(UsuarioModel usuario) {
		
		try {
			UsuarioJPA usuarioJPA = repositorioUsuario.findByUsuarioAndClave(usuario.getUsuario(), usuario.getClave());
			
			if (usuarioJPA == null) {
				log.error("No encontro datos  usuario: " + usuario );
				return false;
			}
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al insertar " + e);
			return false;
		}
		
	}

	
}
