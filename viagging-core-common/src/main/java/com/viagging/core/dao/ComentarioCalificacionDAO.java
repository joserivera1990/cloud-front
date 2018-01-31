package com.viagging.core.dao;

import java.util.List;

import com.viagging.core.model.ComentarioCalificacion;

public interface ComentarioCalificacionDAO {
	
	ComentarioCalificacion getComentarioById(Integer idComentario);

	ComentarioCalificacion createComentario(ComentarioCalificacion comentario);

	ComentarioCalificacion deleteComentario(Integer idComentario);
	
	List<ComentarioCalificacion> findComentariosByPaquete(Integer idPaquete);
	
	List<ComentarioCalificacion> findComentariosByServicio(Integer idServicio);
	
}
