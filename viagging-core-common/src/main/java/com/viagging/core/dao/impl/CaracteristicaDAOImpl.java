package com.viagging.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.viagging.core.dao.CaracteristicaDAO;
import com.viagging.core.model.Caracteristica;

@Repository
public class CaracteristicaDAOImpl implements CaracteristicaDAO {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Caracteristica> getCaracteristicasByCategoria(String categoria) {
		return (List<Caracteristica>) entityManager.createNamedQuery("Caracteristica.findByCategoria").setParameter("categoria", categoria).getResultList();
	}

	@Override
	public Caracteristica getCaracteristicaById(String id) {
		return (Caracteristica) entityManager.createNamedQuery("Caracteristica.findById").setParameter("idCaracteristica", id).getSingleResult();
	}

	@Override
	public Caracteristica getCaracteristicaByCtgAndCars(String categoria, String caracteristica) {
		return (Caracteristica) entityManager.createNamedQuery("Caracteristica.findByCategoriaAndCaracteristica").setParameter("categoria", categoria)
				.setParameter("valor", caracteristica).getSingleResult();
	}


}
