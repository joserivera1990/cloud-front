package com.viagging.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viagging.core.dao.OrdenDAO;
import com.viagging.core.model.Orden;

@Transactional
@Repository
public class OrdenDAOImpl implements OrdenDAO {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Orden> getAllOrdenes() {
		return (List<Orden>) entityManager.createNamedQuery("Orden.findAll").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orden> getOrdenesByUsuario(Integer idUsuario) {
		Query query = entityManager.createNamedQuery("Orden.findByUsuario");
		query.setParameter("idusuario", idUsuario);
		return (List<Orden>) query.getResultList();
	}

	@Override
	public Orden getOrdenById(Integer idOrden) {
		return entityManager.find(Orden.class, idOrden);
	}

	@Override
	public Orden createOrden(Orden orden) {
		entityManager.persist(orden);
		return orden;
	}

	@Override
	public Orden updateOrden(Orden orden) {
		Orden _orden = entityManager.find(Orden.class, orden.getId());
		_orden.setEstado(orden.getEstado());
		entityManager.persist(_orden);
		return _orden;
	}

}
