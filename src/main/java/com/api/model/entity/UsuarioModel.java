package com.api.model.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.api.jpa.entity.UsuarioJPA;

public class UsuarioModel implements Serializable {
	
	private int idUsuario;
	
	@NotBlank (message="nombre de usuario no puede ser vacio")
	private String nombre;
	
	@NotBlank (message="apellido Paterno de usuario no puede ser vacio")
	private String apellidoPaterno;
	
	@NotBlank (message="apellido Materno de usuario no puede ser vacio")
	private String apellidoMaterno;
	
	//@NotBlank (message=" codigo Usuario de usuario no puede ser vacio")
	private String codigoUsuario;
	
	@NotBlank (message="  Usuario  no puede ser vacio")
	private String usuario;
	
	@NotBlank (message=" clave de usuario no puede ser vacio")
	private String clave;
	
	private boolean isEnable;
	
	public UsuarioModel() {
		
	}

	public UsuarioModel(int idUsuario, @NotBlank(message = "nombre de usuario no puede ser vacio") String nombre,
			@NotBlank(message = "apellido Paterno de usuario no puede ser vacio") String apellidoPaterno,
			@NotBlank(message = "apellido Materno de usuario no puede ser vacio") String apellidoMaterno,
			 String codigoUsuario,
			@NotBlank(message = "  Usuario  no puede ser vacio") String usuario,
			@NotBlank(message = " clave de usuario no puede ser vacio") String clave,
			 boolean isEnable) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.codigoUsuario = codigoUsuario;
		this.usuario = usuario;
		this.clave = clave;
		this.isEnable = isEnable;
	}
	
	
	// --------- convertir objeto usuario model ---------------------
	public UsuarioModel(UsuarioJPA usuario) {
		
		this.idUsuario =  usuario.getIdUsuario();
		this.nombre = usuario.getNombre();
		this.apellidoPaterno = usuario.getApellidoPaterno();
		this.apellidoMaterno = usuario.getApellidoMaterno();
		this.codigoUsuario = usuario.getCodigoUsuario();
		this.usuario = usuario.getUsuario();
		this.clave = usuario.getClave();
		this.isEnable = usuario.isEnable();
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public boolean isEnable() {
		return isEnable;
	}

	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}

	@Override
	public String toString() {
		return "UsuarioModel [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno
				+ ", apellidoMaterno=" + apellidoMaterno + ", codigoUsuario=" + codigoUsuario + ", usuario=" + usuario
				+ ", clave=" + clave + ", isEnable=" + isEnable + "]";
	}


}
