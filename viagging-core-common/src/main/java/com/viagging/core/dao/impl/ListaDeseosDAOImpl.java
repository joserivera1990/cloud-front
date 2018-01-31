package com.viagging.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viagging.core.dao.ListaDeseosDAO;
import com.viagging.core.model.ListaDeseos;

@Transactional
@Repository
public class ListaDeseosDAOImpl implements ListaDeseosDAO{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ListaDeseosDAOImpl.class);
	
	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public ListaDeseos getListaDeseosById(Integer idListaDeseos) {
		return entityManager.find(ListaDeseos.class, idListaDeseos);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ListaDeseos> getAllListaDeseos() {
		try{
			return (List<ListaDeseos>) entityManager.createNamedQuery("ListaDeseos.findAll").getResultList();
		} catch(NoResultException e){
			LOGGER.error(e.getMessage());
			return null;
		}
	}

	@Override
	public ListaDeseos createListaDeseos(ListaDeseos listaDeseos) {
		entityManager.persist(listaDeseos);
		return listaDeseos;
	}

	@Override
	public ListaDeseos updateListaDeseos(ListaDeseos listaDeseos) {
		ListaDeseos _listaDeseos = entityManager.find(ListaDeseos.class, listaDeseos.getId());
		_listaDeseos.setIdUsuario(listaDeseos.getIdUsuario());
		_listaDeseos.setPaquete(listaDeseos.getPaquete());
		_listaDeseos.setServicio(listaDeseos.getServicio());
		entityManager.persist(_listaDeseos);
		return _listaDeseos;
	}

	@Override
	public ListaDeseos deleteListaDeseos(Integer idListaDeseos) {
		ListaDeseos listaDeseos = entityManager.find(ListaDeseos.class, idListaDeseos);
		if(listaDeseos != null){
			entityManager.remove(listaDeseos);
		}
		return listaDeseos;
	}

}
