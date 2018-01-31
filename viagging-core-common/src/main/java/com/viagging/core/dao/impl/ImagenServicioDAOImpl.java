package com.viagging.core.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viagging.core.dao.ImagenServicioDAO;
import com.viagging.core.model.ImagenServicio;

@Transactional
@Repository
public class ImagenServicioDAOImpl implements ImagenServicioDAO {

	
	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public ImagenServicio getImagenServicioById(Integer idImagenServicio) {
		return entityManager.find(ImagenServicio.class, idImagenServicio);
	}


	@Override
	public ImagenServicio createImagenServicio( ImagenServicio  imagenServicio){
		entityManager.persist(imagenServicio);
		return imagenServicio;
	}

	@Override
	public ImagenServicio deleteImagenServicio(Integer idImagenServicio){
		ImagenServicio imagenServicio = entityManager.find(ImagenServicio.class, idImagenServicio);
		if (imagenServicio != null) {
			entityManager.remove(imagenServicio);
		}
		return imagenServicio;
	}
}