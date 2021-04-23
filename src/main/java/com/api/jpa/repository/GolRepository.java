package com.api.jpa.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.api.jpa.entity.GolJPA;
import com.api.jpa.entity.JugadorJPA;
import com.api.jpa.entity.PartidoJPA;

@Repository("repositorioGol")
public interface GolRepository extends JpaRepository<GolJPA, Serializable> {
	
	public List<GolJPA> findByJugador (JugadorJPA jugador);
	
	public List<GolJPA> findByPartido (PartidoJPA partido);

}
