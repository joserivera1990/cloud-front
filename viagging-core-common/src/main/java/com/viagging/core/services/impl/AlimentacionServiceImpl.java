package com.viagging.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viagging.core.dao.AlimentacionDAO;
import com.viagging.core.model.Alimentacion;
import com.viagging.core.model.CaracteristicaServicio;
import com.viagging.core.model.Servicio;
import com.viagging.core.services.AlimentacionService;
import com.viagging.core.services.CaracteristicaServicioService;
import com.viagging.core.services.ServicioService;
import com.viagging.rest.dto.AlimentacionDTO;
import com.viagging.rest.dto.CaracteristicaServicioDTO;
import com.viagging.rest.dto.CaracteristicasDTO;


@Service
public class AlimentacionServiceImpl implements  AlimentacionService  {

	
	@Autowired
	private AlimentacionDAO alimentacionDAO;
	
	@Autowired
	private ServicioService servicioService;
	
	@Autowired
	private CaracteristicaServicioService caracteristicaServicioService;
	
	@Override
	public Alimentacion getAlimentacionById(Integer idAlimentacion) {
		return alimentacionDAO.getAlimentacionById(idAlimentacion);
	}

	@Override
	public Alimentacion createAlimentacion(Alimentacion alimentacion) {
		return alimentacionDAO.createAlimentacion(alimentacion);
	}

	@Override
	public Alimentacion updateAlimentacion(Alimentacion alimentacion) {
		return alimentacionDAO.updateAlimentacion(alimentacion);
	}
	
	@Override
	public Alimentacion deleteAlimentacion(Integer idAlimentacion) {
		return alimentacionDAO.deleteAlimentacion(idAlimentacion);
	}

	@Override
	public Integer createAlimentacion(AlimentacionDTO alimentacionDTO) {
		Alimentacion alimentacion = buildAlimentacion(alimentacionDTO);
		createAlimentacion(alimentacion);
		Servicio servicio = servicioService.buildServicio(alimentacionDTO.getServicio());
		servicio.setAlimentacion(alimentacion);
		servicioService.createServicio(servicio);
		alimentacionDTO.getServicio().setId(servicio.getId());
		for (CaracteristicasDTO caracteristica : alimentacionDTO.getServicio().getCaracteristicas()) {
			caracteristica.setCategoria("ALIMENTACION");
			CaracteristicaServicioDTO ca = new CaracteristicaServicioDTO();
			ca.setCaracteristica(caracteristica);
			ca.setServicio(alimentacionDTO.getServicio());
			CaracteristicaServicio caracteristicaServicio = caracteristicaServicioService.buildCaracteristicaServicio(ca);
			caracteristicaServicioService.createCaracteristicaServicio(caracteristicaServicio);
		}
		return servicio.getId();
	}
	
	private Alimentacion buildAlimentacion(AlimentacionDTO alimentacionDTO) {
		Alimentacion alimentacion = new Alimentacion();
		alimentacion.setCiudad(alimentacionDTO.getCiudad());
		alimentacion.setHorarioapertura(alimentacionDTO.getHorarioApertura());
		alimentacion.setHorariocierre(alimentacionDTO.getHorarioCierre());
		alimentacion.setPreciomayor(Integer.parseInt(alimentacionDTO.getPrecioMayor()));
		alimentacion.setPreciomenor(Integer.parseInt(alimentacionDTO.getPrecioMenor()));
		return alimentacion;
	}
}
