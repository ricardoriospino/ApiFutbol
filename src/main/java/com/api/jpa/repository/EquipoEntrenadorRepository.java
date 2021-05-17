package com.api.jpa.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.jpa.entity.EntrenadorJPA;
import com.api.jpa.entity.EquipoEntrenadorJPA;
import com.api.jpa.entity.EquipoJPA;


@Repository("repositorioEquipoEntrenador")
public interface EquipoEntrenadorRepository  extends JpaRepository<EquipoEntrenadorJPA, Serializable> {

	public EquipoEntrenadorJPA findByAnioAndEquipoAndEntrenador (int anio , EquipoJPA equipo , EntrenadorJPA entrenador);
	
	public List<EquipoEntrenadorJPA> findByPartidosJugados (int partidoJugados);
	
	public List<EquipoEntrenadorJPA> findByEntrenador (EntrenadorJPA entrenador);
	
	
	
}
