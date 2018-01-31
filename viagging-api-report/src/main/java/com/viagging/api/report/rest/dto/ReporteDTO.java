package com.viagging.api.report.rest.dto;

import java.util.List;

import com.viagging.rest.dto.PaqueteDTO;
import com.viagging.rest.dto.ServicioDTO;

public class ReporteDTO {
  
	private String tipo;
	
	private String nombre;
	
	private String fecha;
	
	private String primerNombre;

	private String codigoReporte;
	
	private String fechaInical;
	
	private String fechaFinal;
	
	private List<ServicioDTO> listaServicios;
	
	private List<PaqueteDTO> listaPaquetes;
		
	public List<ServicioDTO> getListaServicios() {
		return listaServicios;
	}

	public void setListaServicios(List<ServicioDTO> listaServicios) {
		this.listaServicios = listaServicios;
	}

	public List<PaqueteDTO> getListaPaquetes() {
		return listaPaquetes;
	}

	public void setListaPaquetes(List<PaqueteDTO> listaPaquetes) {
		this.listaPaquetes = listaPaquetes;
	}

	public String getCodigoReporte() {
		return codigoReporte;
	}

	public void setCodigoReporte(String codigoReporte) {
		this.codigoReporte = codigoReporte;
	}

	public String getFechaInical() {
		return fechaInical;
	}

	public void setFechaInical(String fechaInical) {
		this.fechaInical = fechaInical;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
}
