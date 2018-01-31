package com.viagging.core.services.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.core.dao.PreguntaDAO;
import com.viagging.core.model.Pregunta;
import com.viagging.core.services.PreguntaService;
import com.viagging.rest.dto.PaqueteDTO;
import com.viagging.rest.dto.PreguntaDTO;
import com.viagging.rest.dto.ServicioDTO;
import com.viagging.rest.dto.UsuarioDTO;

@Service
public class PreguntaServiceImpl implements PreguntaService{
	
	@Autowired
	private PreguntaDAO preguntaDAO;

	@Override
	public Pregunta getPreguntaById(Integer idPregunta) {
		return preguntaDAO.getPreguntaById(idPregunta);
	}

	@Override
	public Pregunta createPregunta(Pregunta pregunta) {
		return preguntaDAO.createPregunta(pregunta);
	}

	@Override
	public Pregunta updatePregunta(Pregunta pregunta) {
		return preguntaDAO.updatePregunta(pregunta);
	}

	@Override
	public Pregunta deletePregunta(Integer idPregunta) {
		return preguntaDAO.deletePregunta(idPregunta);
	}

	@Override
	public List<Pregunta> findPreguntasByPaquete(Integer idPaquete) {
		return preguntaDAO.findPreguntasByPaquete(idPaquete);
	}

	@Override
	public List<Pregunta> findPreguntasByServicio(Integer idServicio) {
		return preguntaDAO.findPreguntasByServicio(idServicio);
	}

	@Override
	public List<PreguntaDTO> findAllPreguntas() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Pregunta> preguntas = preguntaDAO.findAllPreguntas();
		List<PreguntaDTO> newPreguntas = new ArrayList<>();
		for (Pregunta pregunta : preguntas) {
			UsuarioDTO user = UsuarioDTO.buildObject(pregunta.getUsuario());
			PreguntaDTO preguntaDTO = new PreguntaDTO(pregunta.getId(), pregunta.getPregunta(), pregunta.getRespuesta(), user);
			if (pregunta.getPaquete()!= null) {
				PaqueteDTO paquete = new PaqueteDTO(pregunta.getPaquete().getId(),  pregunta.getPaquete().getNombrePaquete(), String.valueOf(pregunta.getPaquete().getPrecio()), pregunta.getPaquete().getDescripcion());
				preguntaDTO.setPaquete(paquete);
			}
			if (pregunta.getServicio() != null) {
				ServicioDTO servicio = new ServicioDTO(pregunta.getServicio().getId(), pregunta.getServicio().getActivo(), pregunta.getServicio().getNombre(), pregunta.getServicio().getDescripcion(), String.valueOf(pregunta.getServicio().getPrecio()), pregunta.getServicio().getRestricciones(), sdf.format(pregunta.getServicio().getFechaInicio()), sdf.format(pregunta.getServicio().getFechaVigencia()), String.valueOf(pregunta.getServicio().getCapacidad()));
				preguntaDTO.setServicio(servicio);
			}
			newPreguntas.add(preguntaDTO);
		}
		return newPreguntas;
	}

	@Override
	public void responderPregunta(PreguntaDTO question) {
		preguntaDAO.updatePregunta(question);
		
	}

}
