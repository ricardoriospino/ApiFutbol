package com.api.service;

import java.util.List;


import com.api.model.entity.PosicionesModel;

public interface PosicionesService {
	
	public boolean insertar (PosicionesModel posiciones);
	
	public boolean actualizar (PosicionesModel posiciones);
	
	public boolean borrar ( int id);
	
	public List<PosicionesModel> obtenerPosiciones();
	

}
