package com.viagging.core.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.viagging.core.services.VariabilidadService;
import com.viagging.rest.dto.VariabilidadDTO;

@Service
public class VariabilidadServiceImpl implements VariabilidadService{
    
	@Value("${derivador.mensajes}")
	private boolean hasMessage;
	
	@Value("${derivador.reportes}")
	private boolean hasReport;
	
	@Value("${derivador.comentarios}")
	private boolean hasComments;
	
	@Value("${derivador.clima}")
	private boolean hasWeather;
	
	@Value("${derivador.facebook}")
	private boolean hasFacebook;
	
	@Value("${derivador.twitter}")
	private boolean hasTwitter;
	
	@Value("${derivador.pfacebook}")
	private boolean hasPublishFacebook;
	
	@Value("${derivador.ptwitter}")
	private boolean hasPublishTwitter;
	
	@Override
	public VariabilidadDTO getVariabilidad() {
		return new VariabilidadDTO(hasReport, hasMessage, hasComments, hasWeather, hasFacebook, hasTwitter, hasPublishFacebook, hasPublishTwitter);
	}
}
