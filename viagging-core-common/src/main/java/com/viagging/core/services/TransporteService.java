package com.viagging.core.services;

import com.viagging.core.model.Transporte;
import com.viagging.rest.dto.TransporteDTO;

public interface TransporteService {

	Transporte getTransporteById(Integer idTransporte);

	Transporte createTransporte(Transporte transporte);

	Transporte updateTransporte(Transporte transporte);
	
	Transporte deleteTransporte(Integer idTransporte);
	
	Integer createTransporte(TransporteDTO transporte);
}
