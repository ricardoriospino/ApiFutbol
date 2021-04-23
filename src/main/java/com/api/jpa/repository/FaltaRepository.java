package com.api.jpa.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.jpa.entity.FaltaJPA;
import com.api.jpa.entity.JugadorJPA;
import com.api.jpa.entity.PartidoJPA;

@Repository("repositorioFalta")
public interface FaltaRepository extends JpaRepository<FaltaJPA, Serializable> {
	
	public List<FaltaJPA> findByJugador (JugadorJPA jugador);
	
	public List<FaltaJPA> findByPartido (PartidoJPA partido);

}
