package com.api.security.config;

public class AutenticacionRest {

	private String usuario;
	private String clave;
	
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
	public AutenticacionRest(String usuario, String clave) {
		super();
		this.usuario = usuario;
		this.clave = clave;
	}
	
	 public AutenticacionRest() {
		
	}
	@Override
	public String toString() {
		return "AutenticacionRest [usuario=" + usuario + ", clave=" + clave + "]";
		
	}
}
