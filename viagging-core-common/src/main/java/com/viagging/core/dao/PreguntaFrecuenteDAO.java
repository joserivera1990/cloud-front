package com.viagging.core.dao;

import java.util.List;

import com.viagging.core.model.PreguntaFrecuente;

public interface PreguntaFrecuenteDAO {
	
	PreguntaFrecuente getPreguntaFrecuenteById(Integer idPreguntaFrecuente);
	
	List<PreguntaFrecuente> getAllPreguntasFrecuentes();

	PreguntaFrecuente createPreguntaFrecuente(PreguntaFrecuente preguntaFrecuente);

	PreguntaFrecuente updatePreguntaFrecuente(PreguntaFrecuente preguntaFrecuente);

	PreguntaFrecuente deletePreguntaFrecuente(Integer idPreguntaFrecuente);
}
