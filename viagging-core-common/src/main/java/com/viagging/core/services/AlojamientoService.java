package com.viagging.core.services;

import com.viagging.core.model.Alojamiento;
import com.viagging.rest.dto.AlojamientoDTO;

public interface AlojamientoService {

	Alojamiento getAlojamientoById(Integer idAlojamiento);

	Alojamiento createAlojamiento(Alojamiento alojamiento);

	Alojamiento updateAlojamiento(Alojamiento alojamiento);
	
	Alojamiento deleteAlojamiento(Integer idAlojamiento);
	
	Integer createAlojamiento(AlojamientoDTO alojamiento);
}
