package com.viagging.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viagging.core.dao.ConversacionDAO;
import com.viagging.core.model.Conversacion;

@Transactional
@Repository
public class ConversacionDAOImpl implements ConversacionDAO{
	
	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Conversacion getConversacionById(Integer idConversacion) {
		return entityManager.find(Conversacion.class, idConversacion);
	}

	@Override
	public Conversacion createConversacion(Conversacion conversacion) {
		entityManager.persist(conversacion);
		return conversacion;
	}

	@Override
	public Conversacion deleteConversacion(Integer idConversacion) {
		Conversacion conversacion = entityManager.find(Conversacion.class, idConversacion);
		if(conversacion != null){
			entityManager.remove(conversacion);
		}
		return conversacion;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Conversacion> getAllConversaciones() {
		return (List<Conversacion>) entityManager.createNamedQuery("Conversacion.findAll").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Conversacion> getAllConversacionesByUsuario(Integer idUsuario) {
		try {
			Query query = entityManager.createNamedQuery("Conversacion.findByIdUsuario");
			query.setParameter("idusuario", idUsuario);
			return (List<Conversacion>) query.getResultList();
		} catch(NoResultException e){
			return null;
		}
	}

	@Override
	public Conversacion getConversacionByUsuarios(Integer idUsuario1, Integer idUsuario2) {

		try {
			Query query = entityManager.createNamedQuery("Conversacion.findByUsuarios");
			query.setParameter("idusuario1", idUsuario1);
			query.setParameter("idusuario2", idUsuario2);
			return (Conversacion) query.getSingleResult();
		} catch(NoResultException e){
			return null;
		}
	}
}
