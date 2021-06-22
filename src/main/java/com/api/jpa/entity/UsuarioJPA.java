package com.api.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.api.model.entity.UsuarioModel;

@Entity
@Table(name = "tb_usuarios")
public class UsuarioJPA implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private int idUsuario;
	
	@Column(name="nombre"  , nullable=false , length= 50 )
	private String nombre;
	
	@Column(name="apellido_paterno"  , nullable=false , length= 50 )
	private String apellidoPaterno;
	
	@Column(name="apellido_materno"  , nullable=false , length= 50 )
	private String apellidoMaterno;
	
	@Column(name="codigo_usuario"  , nullable=false , unique = true, length= 10 )
	private String codigoUsuario;
	
	@Column(name="usuario"  , nullable=false , unique = true, length= 50 )
	private String usuario;
	
	@Column(name="clave" , nullable=false , length= 50)
	private String clave;
	
	@Column(name="is_enable" , nullable=false)
	private boolean isEnable;
	
	public UsuarioJPA() {
		
	}

	public UsuarioJPA(int idUsuario, String nombre, String apellidoPaterno, String apellidoMaterno,
			String codigoUsuario, String usuario, String clave, boolean isEnable) {
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
		public UsuarioJPA(UsuarioModel usuario) {
			
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
		return "UsuarioJPA [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno
				+ ", apellidoMaterno=" + apellidoMaterno + ", codigoUsuario=" + codigoUsuario + ", usuario=" + usuario
				+ ", clave=" + clave + ", isEnable=" + isEnable + "]";
	}
	
	

}
