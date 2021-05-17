package com.api.rest.dto;



import java.util.List;
import com.api.model.entity.EquipoModel;
import com.api.model.entity.TituloModel;

public class EquipoFullDTO  {
	
	private EquipoModel equipo;
	private List<TituloModel> titulos;
	

	public EquipoFullDTO(List<TituloModel> titulos) {
		super();
		this.titulos = titulos;
	}



	public EquipoFullDTO(EquipoModel equipo, List<TituloModel> titulos) {
		super();
		this.equipo = equipo;
		this.titulos = titulos;
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
