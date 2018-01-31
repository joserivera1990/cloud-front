package com.viagging.core.services;

import java.util.List;

import com.viagging.core.model.Paquete;
import com.viagging.core.model.Servicio;
import com.viagging.rest.dto.PaqueteDTO;

public interface PaqueteService {

	Paquete getPaqueteById(Integer idPaquete);

	List<Paquete> getAllPaquete();

	Paquete createPaquete(Paquete paquete,List<Servicio> listaServicio,String idUsuario);

	Paquete updatePaquete(Paquete paquete);
	
	Paquete buildPaquete(PaqueteDTO paqueteDTO);
	
	List<Paquete> getAllPaquetesByFiltro(String filtro,int idUsuario);
	
	List<Paquete> findAllByCriteria(Paquete paquete);
	
	Paquete activatePaquete(Paquete paquete);
	
	void deletePaquete(Integer idPaquete);

}
