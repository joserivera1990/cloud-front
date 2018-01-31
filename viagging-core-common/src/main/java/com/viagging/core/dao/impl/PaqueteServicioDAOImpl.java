package com.viagging.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viagging.core.dao.PaqueteServicioDAO;
import com.viagging.core.model.PaqueteServicio;

/**
 * The Class ModuloDAOImpl.
 */
@Transactional
@Repository
public class PaqueteServicioDAOImpl implements PaqueteServicioDAO {


	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public PaqueteServicio getPaqueteServicioById(Integer idPaqueteServicio){
		return entityManager.find(PaqueteServicio.class, idPaqueteServicio);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<PaqueteServicio> getAllPaqueteServicio() {
		return (List<PaqueteServicio>) entityManager.createNamedQuery("PaqueteServicio.findAll").getResultList();
	}


	@Override
	public PaqueteServicio createPaqueteServicio(PaqueteServicio paqueteServicio){
		entityManager.persist(paqueteServicio);
		return paqueteServicio;
	}


	@Override
	public PaqueteServicio updatePaqueteServicio(PaqueteServicio paqueteServicio) {
		PaqueteServicio _paqueteServicio = entityManager.find(PaqueteServicio.class, paqueteServicio.getId());
		_paqueteServicio.setId(paqueteServicio.getId());
		entityManager.persist(_paqueteServicio);
		return _paqueteServicio;
	}


	@Override
	public PaqueteServicio deletePaqueteServicio(PaqueteServicio idPaqueteServicio){
		PaqueteServicio paqueteServicio = entityManager.find(PaqueteServicio.class, idPaqueteServicio);
		if (paqueteServicio != null) {
			entityManager.remove(paqueteServicio);
		}
		return paqueteServicio;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PaqueteServicio> getPaqueteServicioByIdPaquete(String idPaquete) {
		return (List<PaqueteServicio>) entityManager.createNamedQuery("PaqueteServicio.findByIdPaquete").setParameter("idPaquete", Integer.valueOf(idPaquete)).getResultList();
	}

}
