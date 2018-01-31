package com.viagging.core.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viagging.core.dao.TransaccionDAO;
import com.viagging.core.model.Transaccion;

@Transactional
@Repository
public class TransaccionDAOImpl implements TransaccionDAO {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Transaccion getTransaccionById(Integer idTransaccion) {
		return entityManager.find(Transaccion.class, idTransaccion);
	}

	@Override
	public Transaccion createTransaccion(Transaccion transaccion) {
		entityManager.persist(transaccion);
		return transaccion;
	}

	@Override
	public Transaccion updateTransaccion(Transaccion transaccion) {
		Transaccion _transaccion = entityManager.find(Transaccion.class, transaccion.getId());
		_transaccion.setEstado(transaccion.getEstado());
		entityManager.persist(_transaccion);
		return _transaccion;
	}

}
