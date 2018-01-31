package com.viagging.core.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.viagging.core.dao.PerfilDAO;
import com.viagging.core.model.Perfil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Transactional
@Repository
public class PerfilDAOImpl implements PerfilDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(PerfilDAOImpl.class);
	
	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;
    	
	@Override
	public Perfil getPerfilById(Integer idPerfil) {
		return entityManager.find(Perfil.class, idPerfil);
	}
	
}