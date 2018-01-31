package com.viagging.core.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.viagging.core.model.Conversacion;
import com.viagging.rest.dto.ConversacionDTO;

@Component
public class ConversacionMapper {
	
	@Autowired
	private UsuarioMapper usuarioMapper;
	
	public Conversacion mapObject(ConversacionDTO conversacionDTO){
		Conversacion conversacion = new Conversacion();
		conversacion.setUsuario1(usuarioMapper.mapObject(conversacionDTO.getUsuario1()));
		conversacion.setUsuario2(usuarioMapper.mapObject(conversacionDTO.getUsuario2()));
		return conversacion;
	}
	
	public List<Conversacion> mapObjectList(List<ConversacionDTO> conversacionesDTO){
		List<Conversacion> conversaciones = new ArrayList<>();
		for(ConversacionDTO conversacionDTO : conversacionesDTO){
			Conversacion conversacion = mapObject(conversacionDTO);
			conversaciones.add(conversacion);
		}
		return conversaciones;
	}

}
