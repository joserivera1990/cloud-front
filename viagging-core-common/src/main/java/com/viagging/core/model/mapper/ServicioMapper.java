package com.viagging.core.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.viagging.core.model.Servicio;
import com.viagging.rest.dto.ServicioDTO;

@Component
public class ServicioMapper {
	
	public Servicio mapObject(ServicioDTO servicioDTO) {
		Servicio servicio = new Servicio();
		servicio.setId(servicioDTO.getId());
		return servicio;
	}

	public List<Servicio> mapObjectList(List<ServicioDTO> serviciosDTO) {
		List<Servicio> servicios = new ArrayList<Servicio>();
		for(ServicioDTO servicioDTO : serviciosDTO){
			servicios.add(mapObject(servicioDTO));
		}
		return servicios;
	}
}
