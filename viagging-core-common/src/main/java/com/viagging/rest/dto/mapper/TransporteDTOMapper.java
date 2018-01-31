package com.viagging.rest.dto.mapper;

import org.springframework.stereotype.Component;

import com.viagging.core.model.Transporte;
import com.viagging.rest.dto.TransporteDTO;

@Component
public class TransporteDTOMapper {

	public  TransporteDTO mapObject(Transporte transporte){
		TransporteDTO transporteDTO = new TransporteDTO();
		transporteDTO.setFrecuenciaSalida(transporte.getFrecuenciasalida());
		transporteDTO.setHorarioFin(transporte.getHorariofin());
		transporteDTO.setHorarioInicio(transporte.getHorarioinicio());
		transporteDTO.setLugarDestino(transporte.getLugardestino());
		transporteDTO.setLugarOrigen(transporte.getLugarorigen());
		transporteDTO.setNumeroPasajeros(String.valueOf(transporte.getNumeropasajeros()));
		transporteDTO.setTiempoEstimado(transporte.getTiempoestimado());
		transporteDTO.setTipoTransporte(transporte.getTipotransporte());
		return transporteDTO;
	}
	
}
