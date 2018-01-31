package com.viagging.api.controllers;

import java.util.List;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.core.services.PreguntaFrecuenteService;
import com.viagging.rest.dto.PreguntaFrecuenteDTO;

@RestController
public class PreguntaFrecuenteController {
	
	public static final String SERVICE_ERROR_MESSAGE_NOT_FOUND = "Preguntas Frecuentes no encontradas";
	
	@Autowired
	private PreguntaFrecuenteService preguntaFrecuenteService;

	@RequestMapping(value = "/faq", method = RequestMethod.GET)
	public List<PreguntaFrecuenteDTO> getPreguntasFrecuentes(){
		List<PreguntaFrecuenteDTO> preguntasFrecuentesDTO = PreguntaFrecuenteDTO.buildListObject(preguntaFrecuenteService.getAllPreguntasFrecuentes());
		if(preguntasFrecuentesDTO.isEmpty()){
			throw new NotFoundException(SERVICE_ERROR_MESSAGE_NOT_FOUND);
		}
		return preguntasFrecuentesDTO;
	}
}
