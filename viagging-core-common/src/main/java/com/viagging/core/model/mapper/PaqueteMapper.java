package com.viagging.core.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.viagging.core.model.Paquete;
import com.viagging.rest.dto.PaqueteDTO;

@Component
public class PaqueteMapper {
	
	public Paquete mapObject(PaqueteDTO paqueteDTO) {
		Paquete paquete = new Paquete();
		paquete.setId(paqueteDTO.getId());
		return paquete;
	}

	public List<Paquete> mapObjectList(List<PaqueteDTO> paquetesDTO) {
		List<Paquete> paquetes = new ArrayList<Paquete>();
		for(PaqueteDTO paqueteDTO : paquetesDTO){
			paquetes.add(mapObject(paqueteDTO));
		}
		return paquetes;
	}
}
