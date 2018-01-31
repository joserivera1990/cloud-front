package com.viagging.rest.dto.mapper;

import org.springframework.stereotype.Component;

import com.viagging.core.model.Alojamiento;
import com.viagging.rest.dto.AlojamientoDTO;

@Component
public class AlojamientoDTOMapper {

	public AlojamientoDTO mapObject(Alojamiento alojamiento){		
		AlojamientoDTO alojamientoDTO = new AlojamientoDTO();
		alojamientoDTO.setCiudad(alojamiento.getCiudad());
		alojamientoDTO.setValorPorNoche(String.valueOf(alojamiento.getValorpornoche()));
		return alojamientoDTO;
	}
	
}
