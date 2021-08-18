package com.api.jpa.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.jpa.entity.EquipoJPA;
import com.api.jpa.entity.TituloJPA;


@Repository("repositorioTitulo")
public interface TituloRepository extends JpaRepository<TituloJPA, Serializable> {
	
	public List<TituloJPA> findByEquipo (EquipoJPA equipo);
	
	public TituloJPA findByIdTitulo (int idTitulo);

	
	
	
	
}
