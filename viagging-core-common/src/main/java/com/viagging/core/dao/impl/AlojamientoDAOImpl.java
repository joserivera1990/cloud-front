package com.viagging.core.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viagging.core.dao.AlojamientoDAO;
import com.viagging.core.model.Alojamiento;

@Transactional
@Repository
public class AlojamientoDAOImpl implements AlojamientoDAO  {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public Alojamiento getAlojamientoById(Integer idAlojamiento) {
		return entityManager.find(Alojamiento.class, idAlojamiento);
	}


	@Override
	public Alojamiento createAlojamiento(Alojamiento alojamiento){
		entityManager.persist(alojamiento);
		return alojamiento;
	}


	@Override
	public Alojamiento updateAlojamiento(Alojamiento alojamiento) {
		Alojamiento _alojamiento = entityManager.find(Alojamiento.class, alojamiento.getId());
		_alojamiento.setCiudad(alojamiento.getCiudad());
		entityManager.persist(_alojamiento);
		return _alojamiento;
	}


	@Override
	public Alojamiento deleteAlojamiento(Integer idAlojamiento){
		Alojamiento alojamiento = entityManager.find(Alojamiento.class, idAlojamiento);
		if (alojamiento != null) {
			entityManager.remove(alojamiento);
		}
		return alojamiento;
	}

}