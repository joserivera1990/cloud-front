package com.viagging.core.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viagging.core.dao.CaracteristicaServicioDAO;
import com.viagging.core.model.CaracteristicaServicio;

@Transactional
@Repository
public class CaracteristicaServicioDAOImpl implements CaracteristicaServicioDAO {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public CaracteristicaServicio createCaracteristicaServicio(CaracteristicaServicio caracteristicaServicio) {
		entityManager.persist(caracteristicaServicio);
		return caracteristicaServicio;
	}


}
