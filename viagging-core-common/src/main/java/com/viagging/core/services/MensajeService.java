package com.viagging.core.services;

import com.viagging.core.model.Mensaje;

public interface MensajeService {
	
	Mensaje getMensajeConversacionById(Integer idMensaje);
	
	Mensaje createMensajeConversacion(Mensaje mensaje);
	
	Mensaje deleteMensajeConversacion(Integer idMensaje);

}
