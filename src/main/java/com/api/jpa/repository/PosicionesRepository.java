package com.api.jpa.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.jpa.entity.PosicionesJPA;

@Repository("repositorioPosiciones")
public interface PosicionesRepository extends JpaRepository<PosicionesJPA, Serializable> {
	
	public PosicionesJPA findByNombreEquipo (String nombre);
	
	public List<PosicionesJPA> findByPuntos(int puntos);
	
	public PosicionesJPA findByTemporada (int temporada);
	
	public List<PosicionesJPA> findByPuntosAndNombreEquipo (int puntos , String nombre);
	
	

}
