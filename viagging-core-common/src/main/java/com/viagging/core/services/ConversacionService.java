package com.viagging.core.services;

import java.util.List;

import com.viagging.core.model.Conversacion;

public interface ConversacionService {
	
	Conversacion getConversacionById(Integer idConversacion);
	
	List<Conversacion> getAllConversaciones();
	
	List<Conversacion> getAllConversacionesByUsuario(Integer idUsuario);

	Conversacion createConversacion(Conversacion conversacion);

	Conversacion deleteConversacion(Integer idConversacion);
	
	Conversacion getConversacionByUsuarios(Integer idUsuario1, Integer idUsuario2);

}
