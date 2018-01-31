package com.viagging.core.dao.impl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viagging.core.dao.MensajeDAO;
import com.viagging.core.model.Mensaje;

@Transactional
@Repository
public class MensajeDAOImpl implements MensajeDAO{

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Mensaje createMensajeConversacion(Mensaje mensaje) {
		mensaje.setFecha(new Date());
		entityManager.persist(mensaje);
		return mensaje;
	}

	@Override
	public Mensaje deleteMensajeConversacion(Integer idMensaje) {
		Mensaje mensaje = entityManager.find(Mensaje.class, idMensaje);
		if(mensaje != null){
			entityManager.remove(mensaje);
		}
		return mensaje;
	}

	@Override
	public Mensaje getMensajeConversacionById(Integer idMensaje) {
		return entityManager.find(Mensaje.class, idMensaje);
	}

}
