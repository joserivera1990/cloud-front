package com.viagging.rest.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.viagging.core.model.Conversacion;
import com.viagging.rest.dto.ConversacionDTO;

@Component
public class ConversacionDTOMapper {

	@Autowired
	private UsuarioDTOMapper usuarioDTOMapper;
	
	@Autowired
	private MensajeDTOMapper mensajeDTOMapper;
	
	public ConversacionDTO mapObject(Conversacion conversacion){
		ConversacionDTO conversacionDTO = new ConversacionDTO();
		conversacionDTO.setId(conversacion.getId());
		conversacionDTO.setUsuario1(usuarioDTOMapper.mapObject(conversacion.getUsuario1()));
		conversacionDTO.setUsuario2(usuarioDTOMapper.mapObject(conversacion.getUsuario2()));
		if(conversacion.getMensajes() != null){
			conversacionDTO.setMensajes(mensajeDTOMapper.mapObjectList(conversacion.getMensajes()));
		}
		return conversacionDTO;
	}
	
	public List<ConversacionDTO> mapObjectList(List<Conversacion> conversaciones){
		List<ConversacionDTO> conversacionesDTO = new ArrayList<>();
		for(Conversacion conversacion : conversaciones){
			ConversacionDTO conversacionDTO = mapObject(conversacion);
			conversacionesDTO.add(conversacionDTO);
		}
		return conversacionesDTO;
	}
}
