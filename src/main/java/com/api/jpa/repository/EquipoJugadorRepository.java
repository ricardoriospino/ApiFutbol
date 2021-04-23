package com.api.jpa.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.jpa.entity.EquipoJPA;
import com.api.jpa.entity.EquipoJugadorJPA;
import com.api.jpa.entity.JugadorJPA;
import com.api.jpa.entity.TituloJPA;

@Repository("repositorioEquipoJugador")
public interface EquipoJugadorRepository extends JpaRepository<EquipoJugadorJPA, Serializable> {
	
	public List<EquipoJugadorJPA> findByJugador (JugadorJPA jugador);
	
}
