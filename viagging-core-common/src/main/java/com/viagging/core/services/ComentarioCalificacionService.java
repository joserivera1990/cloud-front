package com.viagging.core.services;

import java.util.List;

import com.viagging.core.model.ComentarioCalificacion;

public interface ComentarioCalificacionService {

	ComentarioCalificacion getComentarioById(Integer idComentario);

	ComentarioCalificacion createComentario(ComentarioCalificacion comentario);

	ComentarioCalificacion deleteComentario(Integer idComentario);
	
	List<ComentarioCalificacion> findComentariosByPaquete(Integer idPaquete);
	
	List<ComentarioCalificacion> findComentariosByServicio(Integer idServicio);
	
}
