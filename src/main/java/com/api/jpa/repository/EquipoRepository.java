package com.api.jpa.repository;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.jpa.entity.EquipoJPA;


@Repository("repositorioequipo")
public interface EquipoRepository extends JpaRepository<EquipoJPA, Serializable> {
	
	public EquipoJPA findByNombreEquipo (String vnombre);
	
	public EquipoJPA findByAnioFundacion (Date anioFundacion);
	
	public EquipoJPA findByNombreEquipoAndIdEquipo (String vnombre , int id);
	
	public EquipoJPA findByNombreEquipoAndAnioFundacion (String nombre , Date anioFundacion);
	
	public EquipoJPA findByCodigoEquipo (String codigo);
	
	public EquipoJPA findByIdEquipo (int id);
	
	public EquipoJPA findTopByOrderByIdEquipoDesc ();
	
	
	
}
