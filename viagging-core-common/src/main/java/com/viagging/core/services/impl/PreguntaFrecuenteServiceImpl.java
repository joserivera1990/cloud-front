package com.viagging.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.core.dao.PreguntaFrecuenteDAO;
import com.viagging.core.model.PreguntaFrecuente;
import com.viagging.core.services.PreguntaFrecuenteService;

@Service
public class PreguntaFrecuenteServiceImpl implements PreguntaFrecuenteService{

	@Autowired
	private PreguntaFrecuenteDAO preguntaFrecuenteDAO;
	
	@Override
	public PreguntaFrecuente getPreguntaFrecuenteById(Integer idPreguntaFrecuente) {
		return preguntaFrecuenteDAO.getPreguntaFrecuenteById(idPreguntaFrecuente);
	}

	@Override
	public PreguntaFrecuente createPreguntaFrecuente(PreguntaFrecuente preguntaFrecuente) {
		return preguntaFrecuenteDAO.createPreguntaFrecuente(preguntaFrecuente);
	}

	@Override
	public PreguntaFrecuente updatePreguntaFrecuente(PreguntaFrecuente preguntaFrecuente) {
		return preguntaFrecuenteDAO.updatePreguntaFrecuente(preguntaFrecuente);
	}

	@Override
	public PreguntaFrecuente deletePreguntaFrecuente(Integer idPreguntaFrecuente) {
		return preguntaFrecuenteDAO.deletePreguntaFrecuente(idPreguntaFrecuente);
	}

	@Override
	public List<PreguntaFrecuente> getAllPreguntasFrecuentes() {
		return preguntaFrecuenteDAO.getAllPreguntasFrecuentes();
	}
}
