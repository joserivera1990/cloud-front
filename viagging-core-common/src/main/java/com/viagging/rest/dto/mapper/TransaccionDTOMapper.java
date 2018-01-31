package com.viagging.rest.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.viagging.core.mapper.IMapper;
import com.viagging.core.model.Transaccion;
import com.viagging.rest.dto.TransaccionDTO;

@Component
public class TransaccionDTOMapper implements IMapper<Transaccion, TransaccionDTO>{

	@Override
	public TransaccionDTO mapObject(Transaccion transaccion) {
		TransaccionDTO transaccionDTO = new TransaccionDTO();
		transaccionDTO.setId(transaccion.getId());
		transaccionDTO.setCuotas(transaccion.getCuotas());
		transaccionDTO.setEstado(transaccion.getEstado());
		transaccionDTO.setMedioPago(transaccion.getMedioPago());
		transaccionDTO.setNombrePagador(transaccion.getNombrePagador());
		transaccionDTO.setNumeroTarjeta(transaccion.getNumeroTarjeta());
		transaccionDTO.setValor(transaccion.getValor());
		return transaccionDTO;
	}

	@Override
	public List<TransaccionDTO> mapObjectList(List<Transaccion> transacciones) {
		List<TransaccionDTO> transaccionesDTO = new ArrayList<>();
		for(Transaccion transaccion : transacciones){
			TransaccionDTO transaccionDTO = mapObject(transaccion);
			transaccionesDTO.add(transaccionDTO);
		}
		return transaccionesDTO;
	}

}
