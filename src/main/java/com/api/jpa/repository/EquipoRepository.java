package com.api.jpa.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.jpa.entity.EquipoJPA;
import com.api.jpa.entity.TituloJPA;
import com.api.model.entity.EquipoModel;

@Repository("repositorioequipo")
public interface EquipoRepository extends JpaRepository<EquipoJPA, Serializable> {
	
	public EquipoJPA findByNombreEquipo (String vnombre);
	
	public EquipoJPA findByAnioFundacion (Date anioFundacion);
	
	public EquipoJPA findByNombreEquipoAndIdEquipo (String vnombre , int id);
	
	public EquipoJPA findByNombreEquipoAndAnioFundacion (String nombre , Date anioFundacion);
	
	public EquipoJPA findByCodigoEquipo (String codigo);
	
	
	
}
