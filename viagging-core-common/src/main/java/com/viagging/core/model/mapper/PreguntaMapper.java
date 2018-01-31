package com.viagging.core.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.viagging.core.model.Pregunta;
import com.viagging.rest.dto.PreguntaDTO;

@Component
public class PreguntaMapper {
	
	@Autowired
	private UsuarioMapper usuarioMapper;
	
	@Autowired
	private ServicioMapper servicioMapper;
	
	@Autowired
	private PaqueteMapper paqueteMapper;
	
	public Pregunta mapObject(PreguntaDTO preguntaDTO){
		Pregunta pregunta = new Pregunta();
		pregunta.setPregunta(preguntaDTO.getPregunta());
		if(preguntaDTO.getUsuario() != null){
			pregunta.setUsuario(usuarioMapper.mapObject(preguntaDTO.getUsuario()));
		}
		if(preguntaDTO.getServicio() != null){
			pregunta.setServicio(servicioMapper.mapObject(preguntaDTO.getServicio()));
		}
		if(preguntaDTO.getPaquete() != null){
			pregunta.setPaquete(paqueteMapper.mapObject(preguntaDTO.getPaquete()));
		}
		return pregunta;
	}
	
	public List<Pregunta> mapObjectList(List<PreguntaDTO> preguntasDTO){
		List<Pregunta> preguntas = new ArrayList<>();
		for(PreguntaDTO preguntaDTO : preguntasDTO){
			preguntas.add(mapObject(preguntaDTO));
		}
		return preguntas;
	}
	
}
