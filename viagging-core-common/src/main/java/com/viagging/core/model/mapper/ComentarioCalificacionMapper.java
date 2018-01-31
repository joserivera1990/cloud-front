package com.viagging.core.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.viagging.core.model.ComentarioCalificacion;
import com.viagging.rest.dto.ComentarioCalificacionDTO;

@Component
public class ComentarioCalificacionMapper {
	
	@Autowired
	private PaqueteMapper paqueteMapper;
	
	@Autowired
	private ServicioMapper servicioMapper;
	
	@Autowired
	private UsuarioMapper usuarioMapper;
	
	public ComentarioCalificacion mapObject(ComentarioCalificacionDTO comentarioDTO){
		ComentarioCalificacion comentario = new ComentarioCalificacion();
		comentario.setComentario(comentarioDTO.getComentario());
		comentario.setCalificacion(comentarioDTO.getCalificacion());
		if(comentarioDTO.getUsuario() != null){
			comentario.setUsuario(usuarioMapper.mapObject(comentarioDTO.getUsuario()));
		}
		if(comentarioDTO.getServicio() != null){
			comentario.setServicio(servicioMapper.mapObject(comentarioDTO.getServicio()));
		}
		if(comentarioDTO.getPaquete() != null){
			comentario.setPaquete(paqueteMapper.mapObject(comentarioDTO.getPaquete()));
		}
		return comentario;
	}
	
	public List<ComentarioCalificacion> mapObjectList(List<ComentarioCalificacionDTO> comentariosDTO){
		List<ComentarioCalificacion> comentarios = new ArrayList<>();
		for(ComentarioCalificacionDTO comentarioDTO : comentariosDTO){
			comentarios.add(mapObject(comentarioDTO));
		}
		return comentarios;
	}

}
