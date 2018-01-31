package com.viagging.core.dao;

import java.util.List;

import com.viagging.core.model.Paquete;

/**
 * The Interface PaqueteDAO.
 */
public interface PaqueteDAO {

	Paquete getPaqueteById(Integer idPaquete);

	List<Paquete> getAllPaquetes();

	Paquete createPaquete(Paquete paquete);

	Paquete updatePaquete(Paquete paquete);

	void deletePaquete(Integer idPaquete);
	
	List<Paquete> getAllPaquetesByFiltro(String filtro,int idUsuario);

	List<Paquete> findAllByCriteria(Paquete paquete);
	
	Paquete activatePaquete(Paquete paquete);
		
}
