package com.viagging.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PreguntaDTO {
	
	private Integer id;

	private String pregunta;

	private String respuesta;

	private PaqueteDTO paquete;

	private ServicioDTO servicio;

	private UsuarioDTO usuario;
	
	public PreguntaDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public PreguntaDTO(Integer id, String pregunta, String respuesta, UsuarioDTO usuario) {
		this.id = id;
		this.pregunta = pregunta;
		this.respuesta = respuesta;
		this.usuario = usuario;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public PaqueteDTO getPaquete() {
		return paquete;
	}

	public void setPaquete(PaqueteDTO paquete) {
		this.paquete = paquete;
	}

	public ServicioDTO getServicio() {
		return servicio;
	}

	public void setServicio(ServicioDTO servicio) {
		this.servicio = servicio;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	
}
