package com.api.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_security")
public class SecurityRestJPA implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="usuario"  , nullable=false , unique = true, length= 50 )
	private String usuario;
	
	@Column(name="clave" , nullable=false , length= 50)
	private String clave;
	
	@Column(name="rol" , nullable=false)
	private byte rol;
	
	@Column(name="activo" , nullable=false)
	private boolean activo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public byte getRol() {
		return rol;
	}

	public void setRol(byte rol) {
		this.rol = rol;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public SecurityRestJPA(long id, String usuario, String clave, byte rol, boolean activo) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.clave = clave;
		this.rol = rol;
		this.activo = activo;
	}

	public SecurityRestJPA() {
		
	}
	
	
}
