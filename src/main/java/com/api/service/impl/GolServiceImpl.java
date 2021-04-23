package com.api.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.api.jpa.repository.GolRepository;
import com.api.model.entity.GolModel;
import com.api.service.GolService;
import com.api.util.Convertidor;

@Service("golServiceImpl")
public class GolServiceImpl implements GolService {
	private static final Logger log = LogManager.getLogger(GolServiceImpl.class);

	@Autowired
	@Qualifier("repositorioGol")
	private GolRepository repositorioGol;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;

	@Override
	public List<GolModel> obtenerGoles() {
		
		return convertidor.convertirListaGol(repositorioGol.findAll()) ;
	}

}
