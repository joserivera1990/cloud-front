package com.viagging.core.dao;

import java.util.List;

import com.viagging.core.model.PaqueteServicio;

public interface PaqueteServicioDAO  {

	
	
	PaqueteServicio getPaqueteServicioById(Integer idPaqueteServicio);

	List<PaqueteServicio> getAllPaqueteServicio();

	PaqueteServicio createPaqueteServicio(PaqueteServicio paqueteServicio);

	PaqueteServicio updatePaqueteServicio(PaqueteServicio paqueteServicio);


	PaqueteServicio deletePaqueteServicio(PaqueteServicio idPaqueteServicio);
	
	List<PaqueteServicio> getPaqueteServicioByIdPaquete(String idPaquete);
}
