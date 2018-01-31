package com.viagging.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.core.dao.ComentarioCalificacionDAO;
import com.viagging.core.model.ComentarioCalificacion;
import com.viagging.core.services.ComentarioCalificacionService;

@Service
public class ComentarioCalificacionServiceImpl implements ComentarioCalificacionService{

	@Autowired
	private ComentarioCalificacionDAO comentarioCalificacionDAO;
	
	@Override
	public ComentarioCalificacion getComentarioById(Integer idComentario) {
		return comentarioCalificacionDAO.getComentarioById(idComentario);
	}

	@Override
	public ComentarioCalificacion createComentario(ComentarioCalificacion comentario) {
		return comentarioCalificacionDAO.createComentario(comentario);
	}

	@Override
	public ComentarioCalificacion deleteComentario(Integer idComentario) {
		return comentarioCalificacionDAO.deleteComentario(idComentario);
	}

	@Override
	public List<ComentarioCalificacion> findComentariosByPaquete(Integer idPaquete) {
		return comentarioCalificacionDAO.findComentariosByPaquete(idPaquete);
	}

	@Override
	public List<ComentarioCalificacion> findComentariosByServicio(Integer idServicio) {
		return comentarioCalificacionDAO.findComentariosByServicio(idServicio);
	}

}
