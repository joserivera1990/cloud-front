package com.viagging.core.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viagging.core.dao.CompraDAO;
import com.viagging.core.model.Compra;

@Transactional
@Repository
public class CompraDAOImpl implements CompraDAO {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Compra getCompraById(Integer idCompra) {
		return entityManager.find(Compra.class, idCompra);
	}

	@Override
	public Compra createCompra(Compra compra) {
		entityManager.persist(compra);
		return compra;
	}

}
