package com.viagging.rest.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.viagging.core.model.Mensaje;
import com.viagging.rest.dto.MensajeDTO;

@Component
public class MensajeDTOMapper {
	
	public MensajeDTO mapObject(Mensaje mensaje){
		MensajeDTO mensajeDTO = new MensajeDTO();
		mensajeDTO.setId(mensaje.getId());
		mensajeDTO.setIdConversacion(mensaje.getConversacion().getId());
		mensajeDTO.setIdUsuario(mensaje.getUsuario().getId());
		mensajeDTO.setMensaje(mensaje.getMensaje());
		mensajeDTO.setFecha(mensaje.getFecha());
		mensajeDTO.setPrimerNombre(mensaje.getUsuario().getPrimerNombre());
		return mensajeDTO;
	}
	
	public List<MensajeDTO> mapObjectList(List<Mensaje> mensajes){
		List<MensajeDTO> mensajesDTO = new ArrayList<>();
		for(Mensaje mensaje : mensajes){
			MensajeDTO mensajeDTO = mapObject(mensaje);
			mensajesDTO.add(mensajeDTO);
		}
		return mensajesDTO;
		
	}

}
