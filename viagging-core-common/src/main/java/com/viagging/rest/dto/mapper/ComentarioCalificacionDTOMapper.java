package com.viagging.rest.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.viagging.core.model.ComentarioCalificacion;
import com.viagging.rest.dto.ComentarioCalificacionDTO;

@Component
public class ComentarioCalificacionDTOMapper {

	@Autowired
	private UsuarioDTOMapper usuarioDTOMapper;
	
	public ComentarioCalificacionDTO mapObject(ComentarioCalificacion comentario){
		ComentarioCalificacionDTO comentarioDTO = new ComentarioCalificacionDTO();
		comentarioDTO.setComentario(comentario.getComentario());
		comentarioDTO.setCalificacion(comentario.getCalificacion());
		comentarioDTO.setUsuario(usuarioDTOMapper.mapObject(comentario.getUsuario()));
		return comentarioDTO;
	}
	
	public List<ComentarioCalificacionDTO> mapObjectList(List<ComentarioCalificacion> listaComentario){
		List<ComentarioCalificacionDTO> listaComentarioDTO = new ArrayList<>();
		for(ComentarioCalificacion cometario : listaComentario){
			listaComentarioDTO.add(mapObject(cometario));
		}
		return listaComentarioDTO;
	}
	
}
