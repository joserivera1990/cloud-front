package com.viagging.core.dao;

import com.viagging.core.model.Mensaje;

public interface MensajeDAO {
	
	Mensaje getMensajeConversacionById(Integer idMensaje);
	
	Mensaje createMensajeConversacion(Mensaje mensaje);
	
	Mensaje deleteMensajeConversacion(Integer idMensaje);
	
}
