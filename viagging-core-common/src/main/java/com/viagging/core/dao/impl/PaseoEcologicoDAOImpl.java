package com.viagging.core.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viagging.core.dao.PaseoEcologicoDAO;
import com.viagging.core.model.PaseoEcologico;

@Transactional
@Repository
public class PaseoEcologicoDAOImpl implements PaseoEcologicoDAO{
	
	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public PaseoEcologico getPaseoEcologicoById(Integer idPaseoEcologico) {
		return entityManager.find(PaseoEcologico.class, idPaseoEcologico);
	}


	@Override
	public PaseoEcologico createPaseoEcologico(PaseoEcologico paseoEcologico){
		entityManager.persist(paseoEcologico);
		return paseoEcologico;
	}


	@Override
	public PaseoEcologico updatePaseoEcologico(PaseoEcologico paseoEcologico) {
		PaseoEcologico _paseoEcologico = entityManager.find(PaseoEcologico.class, paseoEcologico.getId());
		_paseoEcologico.setCiudad(_paseoEcologico.getCiudad());
		entityManager.persist(_paseoEcologico);
		return _paseoEcologico;
	}


	@Override
	public PaseoEcologico deletePaseoEcologico(Integer idPaseoEcologico){
		PaseoEcologico paseoEcologico = entityManager.find(PaseoEcologico.class, idPaseoEcologico);
		if (paseoEcologico != null) {
			entityManager.remove(paseoEcologico);
		}
		return paseoEcologico;
	}


}