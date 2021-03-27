package com.api.jpa.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.jpa.entity.EquipoJPA;

@Repository("repositorioequipo")
public interface EquipoRepository extends JpaRepository<EquipoJPA, Serializable> {
	
	public EquipoJPA findByNombreEquipo (String vnombre);
	
	public List<EquipoJPA> findByAniosExistencia (int aniosExistencia);
	
	public EquipoJPA findByNombreEquipoAndIdEquipo (String vnombre , int id);
	
	public EquipoJPA findByNombreEquipoAndAnioFundacionAndAniosExistencia (String nombre , Date anioFundacion , int aniosExistencia);

}
