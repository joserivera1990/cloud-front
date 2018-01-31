package com.viagging.rest.dto.mapper;

import org.springframework.stereotype.Component;

import com.viagging.core.model.Alimentacion;
import com.viagging.rest.dto.AlimentacionDTO;

@Component
public class AlimentacionDTOMapper {
	
	public AlimentacionDTO mapObject(Alimentacion alimentacion){		
		AlimentacionDTO alimentacionDTO = new AlimentacionDTO();
		alimentacionDTO.setCiudad(alimentacion.getCiudad());
		alimentacionDTO.setHorarioApertura(alimentacion.getHorarioapertura());
		alimentacionDTO.setHorarioCierre(alimentacion.getHorariocierre());
		alimentacionDTO.setPrecioMayor(String.valueOf(alimentacion.getPreciomayor()));
		alimentacionDTO.setPrecioMenor(String.valueOf(alimentacion.getPreciomenor()));
		return alimentacionDTO;
	}
	
}
