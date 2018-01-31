package com.viagging.core.dao;

import java.util.List;

import com.viagging.core.model.Orden;

public interface OrdenDAO {

	List<Orden> getAllOrdenes();
	
	List<Orden> getOrdenesByUsuario(Integer idUsuario);
	
	Orden getOrdenById(Integer idOrden);

	Orden createOrden(Orden orden);

	Orden updateOrden(Orden orden);

}
