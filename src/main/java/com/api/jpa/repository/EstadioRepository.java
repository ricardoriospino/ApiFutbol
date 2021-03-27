package com.api.jpa.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.jpa.entity.EstadioJPA;

@Repository("repositorioestadio")
public interface EstadioRepository extends JpaRepository<EstadioJPA, Serializable> {
	
	public EstadioJPA findByNombreEstadio (String nombre);
	
	public List<EstadioJPA> findByCapacidad (String capacidad);
	
	public EstadioJPA findByNombreEstadioAndIdEstadio (String nombre , int id);
	
	

}
