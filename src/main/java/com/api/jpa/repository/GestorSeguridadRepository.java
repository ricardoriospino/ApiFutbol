package com.api.jpa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.jpa.entity.SecurityRestJPA;


@Repository("repositorioSecurity")
public interface GestorSeguridadRepository extends JpaRepository<SecurityRestJPA, Serializable> {

	public SecurityRestJPA findByUsuario (String usuario);
}
