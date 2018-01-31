package com.viagging.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viagging.core.dao.PreguntaFrecuenteDAO;
import com.viagging.core.model.PreguntaFrecuente;

@Transactional
@Repository
public class PreguntaFrecuenteDAOImpl implements PreguntaFrecuenteDAO{

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public PreguntaFrecuente getPreguntaFrecuenteById(Integer idPreguntaFrecuente) {
		return entityManager.find(PreguntaFrecuente.class, idPreguntaFrecuente);
	}

	@Override
	public PreguntaFrecuente createPreguntaFrecuente(PreguntaFrecuente preguntaFrecuente) {
		entityManager.persist(preguntaFrecuente);
		return preguntaFrecuente;
	}

	@Override
	public PreguntaFrecuente updatePreguntaFrecuente(PreguntaFrecuente preguntaFrecuente) {
		PreguntaFrecuente _preguntaFrecuente = entityManager.find(PreguntaFrecuente.class, preguntaFrecuente.getId());
		_preguntaFrecuente.setDescripcion(preguntaFrecuente.getDescripcion());
		_preguntaFrecuente.setTitulo(preguntaFrecuente.getTitulo());
		entityManager.persist(_preguntaFrecuente);
		return _preguntaFrecuente;
	}

	@Override
	public PreguntaFrecuente deletePreguntaFrecuente(Integer idPreguntaFrecuente) {
		PreguntaFrecuente preguntaFrecuente = entityManager.find(PreguntaFrecuente.class, idPreguntaFrecuente);
		if(preguntaFrecuente != null){
			entityManager.remove(preguntaFrecuente);
		}
		return preguntaFrecuente;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PreguntaFrecuente> getAllPreguntasFrecuentes(){
		return (List<PreguntaFrecuente>) entityManager.createNamedQuery("PreguntaFrecuente.findAll").getResultList();
	}
}
