package com.viagging.core.dao;

import java.util.List;

import com.viagging.core.model.Caracteristica;


public interface CaracteristicaDAO {

	List<Caracteristica> getCaracteristicasByCategoria(String categoria);
	
	Caracteristica getCaracteristicaById(String id);
	
	Caracteristica getCaracteristicaByCtgAndCars(String categoria, String caracteristica);

}
