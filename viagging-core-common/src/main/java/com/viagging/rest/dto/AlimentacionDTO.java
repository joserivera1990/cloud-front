package com.viagging.rest.dto;

import com.viagging.core.model.Alimentacion;
import com.viagging.core.model.Servicio;
import com.viagging.util.CategoryEnum;

public class AlimentacionDTO {

	private String ciudad;

	private String horarioApertura;
	
	private String horarioCierre;
		
	private String precioMenor;
	
	private String precioMayor;
		
	private ServicioDTO servicio;


	public AlimentacionDTO(){}

	public AlimentacionDTO(String ciudad, String horarioApertura,
			String precioMenor, String precioMayor,
			ServicioDTO servicio,String horarioCierre) {
		super();
		this.ciudad = ciudad;
		this.horarioApertura = horarioApertura;
		this.precioMenor = precioMenor;
		this.precioMayor = precioMayor;
		this.servicio = servicio;
		this.horarioCierre = horarioCierre;
	}
   
	public String getHorarioCierre() {
		return horarioCierre;
	}

	public void setHorarioCierre(String horariocierre) {
		this.horarioCierre = horariocierre;
	}
	
	public ServicioDTO getServicio() {
		return servicio;
	}

	public void setServicio(ServicioDTO servicio) {
		this.servicio = servicio;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getHorarioApertura() {
		return horarioApertura;
	}

	public void setHorarioApertura(String horarioApertura) {
		this.horarioApertura = horarioApertura;
	}

	public String getPrecioMenor() {
		return precioMenor;
	}

	public void setPrecioMenor(String precioMenor) {
		this.precioMenor = precioMenor;
	}

	public String getPrecioMayor() {
		return precioMayor;
	}

	public void setPrecioMayor(String precioMayor) {
		this.precioMayor = precioMayor;
	}
	
	public static AlimentacionDTO buildObject(Servicio servicio) {
		ServicioDTO parserServicio = ServicioDTO.buildObject(servicio);
		parserServicio.setIdCategoria(CategoryEnum.ALIMENTACION.getId());
		Alimentacion alimentacion = servicio.getAlimentacion();
		return new AlimentacionDTO(
				alimentacion.getCiudad(), alimentacion.getHorarioapertura(),
				String.valueOf(alimentacion.getPreciomenor()),
				String.valueOf(alimentacion.getPreciomayor()), parserServicio,
				alimentacion.getHorariocierre());

	}
}