package com.api.jpa.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.jpa.entity.EquipoEstadioJPA;
import com.api.jpa.entity.EstadioJPA;

@Repository("repositorioEquipoEstadio")
public interface EquipoEstadioRepository extends JpaRepository<EquipoEstadioJPA, Serializable> {

	
	public List<EquipoEstadioJPA>  findByEstadio (EstadioJPA estadio);
	
}
