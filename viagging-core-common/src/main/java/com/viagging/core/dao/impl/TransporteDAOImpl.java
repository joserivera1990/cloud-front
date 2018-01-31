package com.viagging.core.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viagging.core.dao.TransporteDAO;
import com.viagging.core.model.Transporte;

@Transactional
@Repository
public class TransporteDAOImpl implements TransporteDAO {
   
	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public Transporte getTransporteById(Integer idTransporte) {
		return entityManager.find(Transporte.class, idTransporte);
	}


	@Override
	public Transporte createTransporte( Transporte  transporte){
		entityManager.persist(transporte);
		return transporte;
	}


	@Override
	public Transporte updateTransporte( Transporte  transporte) {
		Transporte _transporte = entityManager.find(Transporte.class, transporte.getId());
		_transporte.setLugardestino(_transporte.getLugardestino());
		entityManager.persist(_transporte);
		return _transporte;
	}


	@Override
	public Transporte deleteTransporte(Integer idTransporte){
		Transporte transporte = entityManager.find(Transporte.class, idTransporte);
		if (transporte != null) {
			entityManager.remove(transporte);
		}
		return transporte;
	}
}