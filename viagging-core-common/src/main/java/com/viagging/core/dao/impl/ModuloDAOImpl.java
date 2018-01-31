package com.viagging.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viagging.core.dao.ModuloDAO;
import com.viagging.core.model.Modulo;

/**
 * The Class ModuloDAOImpl.
 */
@Transactional
@Repository
public class ModuloDAOImpl implements ModuloDAO {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see com.viagging.core.dao.ModuloDAO#getModuloById(java.lang.Integer)
	 */
	@Override
	public Modulo getModuloById(Integer idModulo) {
		return entityManager.find(Modulo.class, idModulo);
	}

	/* (non-Javadoc)
	 * @see com.viagging.core.dao.ModuloDAO#getAllModulos()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Modulo> getAllModulos() {
		return (List<Modulo>) entityManager.createNamedQuery("Modulo.findAll").getResultList();
	}

	/* (non-Javadoc)
	 * @see com.viagging.core.dao.ModuloDAO#createModulo(com.viagging.core.model.Modulo)
	 */
	@Override
	public Modulo createModulo(Modulo modulo){
		entityManager.persist(modulo);
		return modulo;
	}

	/* (non-Javadoc)
	 * @see com.viagging.core.dao.ModuloDAO#updateModulo(com.viagging.core.model.Modulo)
	 */
	@Override
	public Modulo updateModulo(Modulo modulo) {
		Modulo _modulo = entityManager.find(Modulo.class, modulo.getId());
		_modulo.setNombre(modulo.getNombre());
		_modulo.setPermisoPerfil(modulo.getPermisoPerfil());
		entityManager.persist(_modulo);
		return _modulo;
	}

	/* (non-Javadoc)
	 * @see com.viagging.core.dao.ModuloDAO#deleteModulo(java.lang.Integer)
	 */
	@Override
	public Modulo deleteModulo(Integer idModulo){
		Modulo modulo = entityManager.find(Modulo.class, idModulo);
		if (modulo != null) {
			entityManager.remove(modulo);
		}
		return modulo;
	}

}