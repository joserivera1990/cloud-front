package com.viagging.core.services;

import com.viagging.core.model.CaracteristicaServicio;
import com.viagging.rest.dto.CaracteristicaServicioDTO;


public interface CaracteristicaServicioService {
     
	CaracteristicaServicio createCaracteristicaServicio(CaracteristicaServicio caracteristicaServicio);
	
	void createCaracteristicaServicio(CaracteristicaServicioDTO caracteristicaServicioDTO);
	
	CaracteristicaServicio buildCaracteristicaServicio(CaracteristicaServicioDTO caracteristicaServicioDTO);
	
}
