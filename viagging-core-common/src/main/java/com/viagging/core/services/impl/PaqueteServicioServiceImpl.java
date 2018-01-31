package com.viagging.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viagging.core.dao.PaqueteServicioDAO;
import com.viagging.core.model.PaqueteServicio;
import com.viagging.core.services.PaqueteServicioService;

@Service
public class PaqueteServicioServiceImpl implements PaqueteServicioService{


	
	@Autowired
	private PaqueteServicioDAO paqueteServicioDAO;
	
	@Override
	public List<PaqueteServicio> getPaqueteServicioByIdPaquete(String idPaquete) {
		return paqueteServicioDAO.getPaqueteServicioByIdPaquete(idPaquete);
	}

}
