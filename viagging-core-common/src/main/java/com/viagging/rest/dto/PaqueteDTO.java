package com.viagging.rest.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.viagging.core.constant.EstadoItem;
import com.viagging.core.model.Paquete;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaqueteDTO {
	
	private Integer id;

	private boolean activo;
	
	private String nombre;
	
	private String precio;
	
	private String descripcion;
	
	private String fechaInicial;
	
	private String fechaFinal;
	
	private String capacidad;
	
	private Integer numeroAdquiridos;
	
	private UsuarioDTO usuario;
	
	private List<ServicioDTO>servicios;
		
	public PaqueteDTO(){}
	
	public PaqueteDTO(Integer id, String nombre, String precio,String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
	}

	public List<ServicioDTO> getServicios() {
		return servicios;
	}

	public void setServicios(List<ServicioDTO> servicios) {
		this.servicios = servicios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
    
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public String getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public String getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	
	public Integer getNumeroAdquiridos() {
		return numeroAdquiridos;
	}

	public void setNumeroAdquiridos(Integer numeroAdquiridos) {
		this.numeroAdquiridos = numeroAdquiridos;
	}

	public static List<PaqueteDTO> buildListObject(List<Paquete> listaPaquete){
		List<PaqueteDTO> listaPaqueteDTO = new ArrayList<>();
		for (Paquete paquete : listaPaquete) {
			PaqueteDTO paqueteDTO = new PaqueteDTO(paquete.getId(), paquete.getNombrePaquete(), String.valueOf(paquete.getPrecio()),paquete.getDescripcion());
		    paqueteDTO.setActivo(paquete.getEstado().equals(EstadoItem.ACTIVO.getId()) ? true : false);
			listaPaqueteDTO.add(paqueteDTO);
		}
		return listaPaqueteDTO;
	}

}
