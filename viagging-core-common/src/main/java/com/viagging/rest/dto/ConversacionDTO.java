package com.viagging.rest.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConversacionDTO {
	
	private Integer id;

	private UsuarioDTO usuario1;

	private UsuarioDTO usuario2;
	
	private List<MensajeDTO> mensajes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UsuarioDTO getUsuario1() {
		return usuario1;
	}

	public void setUsuario1(UsuarioDTO usuario1) {
		this.usuario1 = usuario1;
	}

	public UsuarioDTO getUsuario2() {
		return usuario2;
	}

	public void setUsuario2(UsuarioDTO usuario2) {
		this.usuario2 = usuario2;
	}

	public List<MensajeDTO> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<MensajeDTO> mensajes) {
		this.mensajes = mensajes;
	}
	
}
