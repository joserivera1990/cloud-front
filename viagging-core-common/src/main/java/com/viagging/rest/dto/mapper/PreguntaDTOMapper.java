package com.viagging.rest.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.viagging.core.model.Pregunta;
import com.viagging.rest.dto.PreguntaDTO;

@Component
public class PreguntaDTOMapper {
	
	public PreguntaDTO mapObject(Pregunta pregunta){
		PreguntaDTO preguntaDTO = new PreguntaDTO();
		preguntaDTO.setId(pregunta.getId());
		preguntaDTO.setPregunta(pregunta.getPregunta());
		preguntaDTO.setRespuesta(pregunta.getRespuesta());
		return preguntaDTO;
	}

	public List<PreguntaDTO> mapObjectList(List<Pregunta> listaPreguntas){
		List<PreguntaDTO> listaPreguntasDTO = new ArrayList<>();
		for(Pregunta pregunta : listaPreguntas){
			listaPreguntasDTO.add(mapObject(pregunta));
		}
		return listaPreguntasDTO;
	}
}
