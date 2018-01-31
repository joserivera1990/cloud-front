package com.viagging.rest.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.viagging.core.model.CaracteristicaServicio;
import com.viagging.rest.dto.CaracteristicaServicioDTO;

@Component
public class CaracteristicaServicioDTOMapper {
	
	@Autowired
	private CaracteristicaDTOMapper caracteristicaDTOMapper;

	public CaracteristicaServicioDTO mapObject(CaracteristicaServicio caracteristicaServicio){
		CaracteristicaServicioDTO caracteristicaServicioDTO = new CaracteristicaServicioDTO();
		caracteristicaServicioDTO.setCaracteristica(caracteristicaDTOMapper.mapObject(caracteristicaServicio.getCaracteristica()));
		return caracteristicaServicioDTO;
	}
	
	public List<CaracteristicaServicioDTO> mapObjectList(List<CaracteristicaServicio> caracteristicasServicio){
		List<CaracteristicaServicioDTO> caracteristicasServicioDTO = new ArrayList<>();
		for(CaracteristicaServicio caracteristicaServicio : caracteristicasServicio){
			caracteristicasServicioDTO.add(mapObject(caracteristicaServicio));
		}
		return caracteristicasServicioDTO;
	}

	
}
