package com.api.jpa.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.jpa.entity.PartidoJPA;

@Repository("repositorioPartido")
public interface PartidoRepository extends JpaRepository<PartidoJPA, Serializable>{

	public PartidoJPA findByCodigoPartido (String codigo);
	
	public List<PartidoJPA> findByFechaHora (Date fecha);
	
	public List<PartidoJPA> findByArbitro (String arbitro);
	
	public PartidoJPA findByEquipo1 (int codigo);
	
	public PartidoJPA findByEquipo2 (int codigo);
}
