package com.viagging.rest.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.viagging.core.model.Caracteristica;
import com.viagging.core.model.CaracteristicaServicio;
import com.viagging.rest.dto.CaracteristicaServicioDTO;
import com.viagging.rest.dto.CaracteristicasDTO;

@Component
public class CaracteristicaDTOMapper {

	@Autowired
	private CaracteristicaServicioDTOMapper caracteristicaServicioDTOMapper;
	
	public CaracteristicasDTO mapObject(Caracteristica caracteristica){
		CaracteristicasDTO caracteristicaDTO = new CaracteristicasDTO();
		caracteristicaDTO.setValor(caracteristica.getValor());
		caracteristicaDTO.setCategoria(caracteristica.getCategoria());
		caracteristicaDTO.setId(String.valueOf(caracteristica.getId()));
		return caracteristicaDTO;
	}
	
	public List<CaracteristicasDTO> mapObjectList(List<Caracteristica> caracteristicas){
		List<CaracteristicasDTO> caracteristicasDTO = new ArrayList<>();
		for(Caracteristica caracteristica : caracteristicas){
			caracteristicasDTO.add(mapObject(caracteristica));
		}
		return caracteristicasDTO;
	}
	
	public List<CaracteristicasDTO> mapObjectListFromCaracteristicaServicio(List<CaracteristicaServicio> caracteristicasServicio){
		List<CaracteristicasDTO> caracteristicas = new ArrayList<>();
		for(CaracteristicaServicio caracteristicaServicio : caracteristicasServicio){
			CaracteristicaServicioDTO caracteristicaServicioDTO = caracteristicaServicioDTOMapper.mapObject(caracteristicaServicio);
			caracteristicas.add(caracteristicaServicioDTO.getCaracteristica());
		}
		return caracteristicas;
	}
	
	
}
