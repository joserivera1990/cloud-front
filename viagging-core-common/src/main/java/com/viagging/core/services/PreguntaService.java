package com.viagging.core.services;

import java.util.List;

import com.viagging.core.model.Pregunta;
import com.viagging.rest.dto.PreguntaDTO;

public interface PreguntaService {
	
	Pregunta getPreguntaById(Integer idPregunta);

	Pregunta createPregunta(Pregunta pregunta);

	Pregunta updatePregunta(Pregunta pregunta);
	
	Pregunta deletePregunta(Integer idPregunta);
	
	List<Pregunta> findPreguntasByPaquete(Integer idPaquete);
	
	List<Pregunta> findPreguntasByServicio(Integer idServicio);
	
	List<PreguntaDTO> findAllPreguntas();

	void responderPregunta(PreguntaDTO question);

}
