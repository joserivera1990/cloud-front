package com.viagging.core.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.viagging.core.model.Conversacion;
import com.viagging.core.model.Mensaje;
import com.viagging.core.model.Usuario;
import com.viagging.rest.dto.MensajeDTO;

@Component
public class MensajeMapper {
	
	public Mensaje mapObject(MensajeDTO mensajeDTO){
		Mensaje mensaje = new Mensaje();
		Conversacion conversacion = new Conversacion();
		conversacion.setId(mensajeDTO.getIdConversacion());
		mensaje.setConversacion(conversacion);
		mensaje.setMensaje(mensajeDTO.getMensaje());
		mensaje.setFecha(mensajeDTO.getFecha());
		Usuario usuario = new Usuario();
		usuario.setId(mensajeDTO.getIdUsuario());
		mensaje.setUsuario(usuario);
		return mensaje;
	}
	
	public List<Mensaje> mapObjectList(List<MensajeDTO> mensajesDTO){
		List<Mensaje> mensajes = new ArrayList<>();
		for(MensajeDTO mensajeDTO : mensajesDTO){
			Mensaje mensaje = mapObject(mensajeDTO);
			mensajes.add(mensaje);
		}
		return mensajes;
	}

}
