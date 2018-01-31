package com.viagging.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.viagging.core.model.Paquete;
import com.viagging.core.model.Servicio;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaqueteServicioDTO {
	
	private Integer id;
	
	private Paquete paquete;

	private Servicio servicio;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Paquete getPaquete() {
		return paquete;
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}
