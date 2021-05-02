package com.api.model.entity;

import java.io.Serializable;
import java.util.List;

public class ResponseErrorListModel implements Serializable {
	
	private List<ResponseErrorModel> listaError;
	
	
	public ResponseErrorListModel() {
		
	}


	public ResponseErrorListModel(List<ResponseErrorModel> listaError) {
		super();
		this.listaError = listaError;
	}


	public List<ResponseErrorModel> getListaError() {
		return listaError;
	}


	public void setListaError(List<ResponseErrorModel> listaError) {
		this.listaError = listaError;
	}
	
	

}
