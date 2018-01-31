package com.viagging.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viagging.core.dao.ComentarioCalificacionDAO;
import com.viagging.core.model.ComentarioCalificacion;

@Transactional
@Repository
public class ComentarioCalificacionDAOImpl implements ComentarioCalificacionDAO{
	
	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public ComentarioCalificacion getComentarioById(Integer idComentario) {
		return entityManager.find(ComentarioCalificacion.class, idComentario);
	}

	@Override
	public ComentarioCalificacion createComentario(ComentarioCalificacion comentario) {
		entityManager.persist(comentario);
		return comentario;
	}

	@Override
	public ComentarioCalificacion deleteComentario(Integer idComentario) {
		ComentarioCalificacion comentario = entityManager.find(ComentarioCalificacion.class, idComentario);
		if(comentario != null){
			entityManager.remove(comentario);
		}
		return comentario;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ComentarioCalificacion> findComentariosByPaquete(Integer idPaquete) {
		try {
			Query query = entityManager.createNamedQuery("ComentarioCalificacion.findByIdPaquete");
			query.setParameter("idpaquete", idPaquete);
			return (List<ComentarioCalificacion>) query.getResultList();
		} catch(NoResultException e){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ComentarioCalificacion> findComentariosByServicio(Integer idServicio) {
		try {
			Query query = entityManager.createNamedQuery("ComentarioCalificacion.findByIdServicio");
			query.setParameter("idservicio", idServicio);
			return (List<ComentarioCalificacion>) query.getResultList();
		} catch(NoResultException e){
			return null;
		}
	}

}
