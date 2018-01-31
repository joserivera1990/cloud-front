package com.viagging.rest.dto;

import com.viagging.core.model.PaseoEcologico;
import com.viagging.core.model.Servicio;
import com.viagging.util.CategoryEnum;

public class PaseoEcologicoDTO {
 	
	private String fecha;

	private String ciudad;
	
	private String tiempoDeRecorrido;
	
	private String horario;
	    
	private ServicioDTO servicio;
	
	public PaseoEcologicoDTO(){}
	
	
	public PaseoEcologicoDTO(String fecha, String ciudad,
			String tiempoDeRecorrido, String horario, ServicioDTO servicio) {
		super();
		this.fecha = fecha;
		this.ciudad = ciudad;
		this.tiempoDeRecorrido = tiempoDeRecorrido;
		this.horario = horario;
		this.servicio = servicio;
	}
    
	public ServicioDTO getServicio() {
		return servicio;
	}

	public void setServicio(ServicioDTO servicio) {
		this.servicio = servicio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTiempoDeRecorrido() {
		return tiempoDeRecorrido;
	}

	public void setTiempoDeRecorrido(String tiempoDeRecorrido) {
		this.tiempoDeRecorrido = tiempoDeRecorrido;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public static PaseoEcologicoDTO buildObject(Servicio servicio){
		ServicioDTO parserServicio = ServicioDTO.buildObject(servicio);
		parserServicio.setIdCategoria(CategoryEnum.PASEO_ECOLOGICO.getId());
		PaseoEcologico paseoEcologico = servicio.getPaseoEcologico();	
		return  new PaseoEcologicoDTO(
				paseoEcologico.getFecha() != null ? paseoEcologico.getFecha().toString() : "",
				paseoEcologico.getCiudad(),
				paseoEcologico.getTiempoderecorrido(),
				paseoEcologico.getHorario(), parserServicio);
		
	}
}