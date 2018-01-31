package com.viagging.core.services;

import java.util.List;

import com.viagging.core.model.Orden;

public interface OrdenService {

	List<Orden> getAllOrdenes();
	
	List<Orden> getOrdenesByUsuario(Integer idUsuario);
	
	Orden getOrdenById(Integer idOrden);

	Orden createOrden(Orden orden);

	Orden updateOrden(Orden orden);
	
}
