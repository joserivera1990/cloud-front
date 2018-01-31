package com.viagging.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.core.dao.ConversacionDAO;
import com.viagging.core.model.Conversacion;
import com.viagging.core.services.ConversacionService;

@Service
public class ConversacionServiceImpl implements ConversacionService{
	
	@Autowired
	private ConversacionDAO conversacionDAO;

	@Override
	public Conversacion getConversacionById(Integer idConversacion) {
		return conversacionDAO.getConversacionById(idConversacion);
	}

	@Override
	public Conversacion createConversacion(Conversacion conversacion) {
		return conversacionDAO.createConversacion(conversacion);
	}

	@Override
	public Conversacion deleteConversacion(Integer idConversacion) {
		return conversacionDAO.deleteConversacion(idConversacion);
	}

	@Override
	public List<Conversacion> getAllConversaciones() {
		return conversacionDAO.getAllConversaciones();
	}

	@Override
	public List<Conversacion> getAllConversacionesByUsuario(Integer idUsuario) {
		return conversacionDAO.getAllConversacionesByUsuario(idUsuario);
	}

	@Override
	public Conversacion getConversacionByUsuarios(Integer idUsuario1, Integer idUsuario2) {
		return conversacionDAO.getConversacionByUsuarios(idUsuario1, idUsuario2);
	}

}
