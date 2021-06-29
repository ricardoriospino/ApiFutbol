package com.api.jpa.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.jpa.entity.EntrenadorJPA;
import com.api.jpa.entity.UsuarioJPA;

@Repository("repositorioentrenador")
public interface EntrenadorRepository extends JpaRepository<EntrenadorJPA, Serializable> {
	
	public EntrenadorJPA findByNombreEntrenador (String vnombre);
	
	public List<EntrenadorJPA> findByNacionalidad (String vnacionalidad);
	
	public EntrenadorJPA findByNombreEntrenadorAndIdEntrenador (String vnombre, int vid);
	
	public EntrenadorJPA findByNombreEntrenadorAndNacionalidad (String vnombre, String vnacionalidad);
	
	public EntrenadorJPA findBycodigoEntrenador (String codigo);
	
	public EntrenadorJPA findByIdEntrenador (int id);
	
	public EntrenadorJPA findTopByOrderByIdEntrenadorDesc();
	

}
