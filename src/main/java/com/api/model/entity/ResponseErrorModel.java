package com.api.model.entity;

import java.io.Serializable;

public class ResponseErrorModel implements Serializable {
	
	
	private String codigoError;
	
	private String mensajeError;
	
	

	public ResponseErrorModel() {
		
	}



	public ResponseErrorModel(String codigoError, String mensajeError) {
		super();
		this.codigoError = codigoError;
		this.mensajeError = mensajeError;
	}



	public String getCodigoError() {
		return codigoError;
	}



	public void setCodigoError(String codigoError) {
		this.codigoError = codigoError;
	}



	public String getMensajeError() {
		return mensajeError;
	}



	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}



	@Override
	public String toString() {
		return "ResponseErrorModel [codigoError=" + codigoError + ", mensajeError=" + mensajeError + "]";
	}
	
	
}
