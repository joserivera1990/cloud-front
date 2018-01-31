package com.viagging.core.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viagging.core.dao.AlimentacionDAO;
import com.viagging.core.model.Alimentacion;

@Transactional
@Repository
public class AlimentacionDAOImpl implements AlimentacionDAO {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public Alimentacion getAlimentacionById(Integer idAlimentacion) {
		return entityManager.find(Alimentacion.class, idAlimentacion);
	}


	@Override
	public Alimentacion createAlimentacion(Alimentacion alimentacion){
		entityManager.persist(alimentacion);
		return alimentacion;
	}


	@Override
	public Alimentacion updateAlimentacion(Alimentacion alimentacion) {
		Alimentacion _alimentacion = entityManager.find(Alimentacion.class, alimentacion.getId());
		_alimentacion.setCiudad(alimentacion.getCiudad());
		entityManager.persist(_alimentacion);
		return _alimentacion;
	}


	@Override
	public Alimentacion deleteAlimentacion(Integer idAlimentacion){
		Alimentacion alimentacion = entityManager.find(Alimentacion.class, idAlimentacion);
		if (alimentacion != null) {
			entityManager.remove(alimentacion);
		}
		return alimentacion;
	}
}