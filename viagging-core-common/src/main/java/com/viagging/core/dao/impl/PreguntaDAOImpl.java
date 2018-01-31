package com.viagging.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viagging.core.dao.PreguntaDAO;
import com.viagging.core.model.Pregunta;
import com.viagging.rest.dto.PreguntaDTO;

@Transactional
@Repository
public class PreguntaDAOImpl implements PreguntaDAO{
	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Pregunta getPreguntaById(Integer idPregunta) {
		return entityManager.find(Pregunta.class, idPregunta);
	}

	@Override
	public Pregunta createPregunta(Pregunta pregunta) {
		entityManager.persist(pregunta);
		return pregunta;
	}

	@Override
	public Pregunta updatePregunta(Pregunta pregunta) {
		Pregunta _pregunta = entityManager.find(Pregunta.class, pregunta.getId());
		_pregunta.setRespuesta(pregunta.getRespuesta());
		_pregunta.setPregunta(pregunta.getPregunta());
		entityManager.persist(_pregunta);
		return null;
	}
	
	@Override
	public Pregunta updatePregunta(PreguntaDTO pregunta) {
		Pregunta _pregunta = entityManager.find(Pregunta.class, pregunta.getId());
		_pregunta.setRespuesta(pregunta.getRespuesta());
		_pregunta.setPregunta(pregunta.getPregunta());
		entityManager.persist(_pregunta);
		return null;
	}
	
	
	@Override
	public Pregunta deletePregunta(Integer idPregunta) {
		Pregunta pregunta = entityManager.find(Pregunta.class, idPregunta);
		if(pregunta != null){
			entityManager.remove(pregunta);
		}
		return pregunta;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pregunta> findPreguntasByPaquete(Integer idPaquete) {
		try {
			Query query = entityManager.createNamedQuery("Pregunta.findByIdPaquete");
			query.setParameter("idpaquete", idPaquete);
			return (List<Pregunta>) query.getResultList();
		} catch(NoResultException e){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pregunta> findPreguntasByServicio(Integer idServicio) {
		try {
			Query query = entityManager.createNamedQuery("Pregunta.findByIdServicio");
			query.setParameter("idservicio", idServicio);
			return (List<Pregunta>) query.getResultList();
		} catch(NoResultException e){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pregunta> findAllPreguntas() {
		try {
			Query query = entityManager.createNamedQuery("Pregunta.findAll");
			List<Pregunta> preguntas = (List<Pregunta>) query.getResultList();
			return preguntas;
		} catch(NoResultException e){
			return null;
		}
	}

}
