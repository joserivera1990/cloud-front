package com.viagging.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.core.dao.MensajeDAO;
import com.viagging.core.model.Mensaje;
import com.viagging.core.services.MensajeService;

@Service
public class MensajeServiceImpl implements MensajeService{

	@Autowired
	private MensajeDAO mensajeDAO;
	
	@Override
	public Mensaje getMensajeConversacionById(Integer idMensaje) {
		return mensajeDAO.getMensajeConversacionById(idMensaje);
	}

	@Override
	public Mensaje createMensajeConversacion(Mensaje mensaje) {
		return mensajeDAO.createMensajeConversacion(mensaje);
	}

	@Override
	public Mensaje deleteMensajeConversacion(Integer idMensaje) {
		return mensajeDAO.deleteMensajeConversacion(idMensaje);
	}

}
