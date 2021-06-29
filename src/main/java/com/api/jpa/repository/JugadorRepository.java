package com.api.jpa.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.jpa.entity.JugadorJPA;
import com.api.jpa.entity.UsuarioJPA;

@Repository("repositoriojugador")
public interface JugadorRepository extends JpaRepository<JugadorJPA, Serializable> {
	
	public JugadorJPA findByNombreJugador (String nombre);
	
	public List<JugadorJPA> findByNacionalidad (String nacionalidad);
	
	public JugadorJPA findByDorsalAndNacionalidad (int dorsal , String nacionalidad);
	
	public JugadorJPA findByNombreJugadorAndNacionalidad (String nombre , String nacionalidad);
	
	public JugadorJPA findByCodigoJugador (String codigo);
	
	public JugadorJPA findByIdJugador (int id);
	
	public JugadorJPA findTopByOrderByIdJugadorDesc();

}
