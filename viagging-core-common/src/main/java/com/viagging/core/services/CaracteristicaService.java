package com.viagging.core.services;

import java.util.List;

import com.viagging.core.model.Caracteristica;


public interface CaracteristicaService {
     
	List<Caracteristica> getCaracteristicaByCategoria(String categoria);

}
