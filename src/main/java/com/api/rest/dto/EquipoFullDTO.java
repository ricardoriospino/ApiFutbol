package com.api.rest.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.api.jpa.entity.EquipoJPA;
import com.api.model.entity.EquipoModel;
import com.api.model.entity.TituloModel;

public class EquipoFullDTO implements Serializable {
	
	private EquipoModel equipo;
	private List<TituloModel> titulos;
	

	
	public EquipoFullDTO() {
		
		
	}


	public EquipoFullDTO(List<TituloModel> titulos) {
		super();
		this.titulos = titulos;
	}


	public EquipoFullDTO(EquipoModel equipo, List<TituloModel> titulos) {
		super();
		this.equipo = equipo;
		this.titulos = titulos;
	}

	public EquipoFullDTO(List<EquipoModel> equipo2, ArrayList<EquipoJPA> equipoTitulos) {
		// TODO Auto-generated constructor stub
	}


	public EquipoModel getEquipo() {
		return equipo;
	}

	public void setEquipo(EquipoModel equipo) {
		this.equipo = equipo;
	}

	public List<TituloModel> getTitulos() {
		return titulos;
	}

	public void setTitulos(List<TituloModel> titulos) {
		this.titulos = titulos;
	}


	
	

}
