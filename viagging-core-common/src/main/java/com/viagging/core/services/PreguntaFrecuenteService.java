package com.viagging.core.services;

import java.util.List;

import com.viagging.core.model.PreguntaFrecuente;

public interface PreguntaFrecuenteService {
	
	PreguntaFrecuente getPreguntaFrecuenteById(Integer idPreguntaFrecuente);
	
	List<PreguntaFrecuente> getAllPreguntasFrecuentes();

	PreguntaFrecuente createPreguntaFrecuente(PreguntaFrecuente preguntaFrecuente);

	PreguntaFrecuente updatePreguntaFrecuente(PreguntaFrecuente preguntaFrecuente);

	PreguntaFrecuente deletePreguntaFrecuente(Integer idPreguntaFrecuente);
}
