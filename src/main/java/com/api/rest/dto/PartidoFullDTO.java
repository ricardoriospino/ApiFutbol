package com.api.rest.dto;

import java.util.List;

import com.api.model.entity.FaltaModel;
import com.api.model.entity.GolModel;
import com.api.model.entity.PartidoModel;

public class PartidoFullDTO {

	private PartidoModel partido;
	private List<GolModel> gol;
	private List<FaltaModel >falta;
	public PartidoModel getPartido() {
		return partido;
	}
	public void setPartido(PartidoModel partido) {
		this.partido = partido;
	}
	public List<GolModel> getGol() {
		return gol;
	}
	public void setGol(List<GolModel> gol) {
		this.gol = gol;
	}
	public List<FaltaModel> getFalta() {
		return falta;
	}
	public void setFalta(List<FaltaModel> falta) {
		this.falta = falta;
	}
	public PartidoFullDTO(PartidoModel partido, List<GolModel> gol, List<FaltaModel> falta) {
		super();
		this.partido = partido;
		this.gol = gol;
		this.falta = falta;
	}
	
	
}
