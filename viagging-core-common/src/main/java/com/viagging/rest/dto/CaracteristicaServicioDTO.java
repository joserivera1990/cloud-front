package com.viagging.rest.dto;

public class CaracteristicaServicioDTO {
    
	private CaracteristicasDTO caracteristica;
	
	private ServicioDTO servicio;

	public CaracteristicasDTO getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(CaracteristicasDTO caracteristica) {
		this.caracteristica = caracteristica;
	}

	public ServicioDTO getServicio() {
		return servicio;
	}

	public void setServicio(ServicioDTO servicio) {
		this.servicio = servicio;
	}

}
