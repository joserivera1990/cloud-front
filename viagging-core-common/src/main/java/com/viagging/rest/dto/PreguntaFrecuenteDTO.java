package com.viagging.rest.dto;

import java.util.ArrayList;
import java.util.List;
import com.viagging.core.model.PreguntaFrecuente;

public class PreguntaFrecuenteDTO {
	
	private Integer id;

	private String titulo;
	
	private String descripcion;

	public PreguntaFrecuenteDTO(){}
	
	public PreguntaFrecuenteDTO(Integer id, String titulo, String descripcion){
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public static PreguntaFrecuenteDTO buildObject(PreguntaFrecuente preguntaFrecuente){
		PreguntaFrecuenteDTO preguntaFrecuenteDTO = new PreguntaFrecuenteDTO();
		preguntaFrecuenteDTO.setId(Integer.valueOf(preguntaFrecuente.getId()));
		preguntaFrecuenteDTO.setTitulo(preguntaFrecuente.getTitulo());
		preguntaFrecuenteDTO.setDescripcion(preguntaFrecuente.getDescripcion());
		
		return preguntaFrecuenteDTO;
	}
	
	public static List<PreguntaFrecuenteDTO> buildListObject(List<PreguntaFrecuente> listaPreguntaFrecuente){
		List<PreguntaFrecuenteDTO> listaPreguntaFrecuenteDTO = new ArrayList<>();
		for(PreguntaFrecuente preguntaFrecuente : listaPreguntaFrecuente){
			PreguntaFrecuenteDTO preguntaFrecuenteDTO = PreguntaFrecuenteDTO.buildObject(preguntaFrecuente);
			listaPreguntaFrecuenteDTO.add(preguntaFrecuenteDTO);
		}
		return listaPreguntaFrecuenteDTO;
	}
}
