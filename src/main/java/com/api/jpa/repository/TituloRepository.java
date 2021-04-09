package com.api.jpa.repository;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.api.jpa.entity.TituloJPA;

@Repository("repositorioTitulo")
public interface TituloRepository extends JpaRepository<TituloJPA, Serializable> {
	
	
}
