package com.viagging.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.core.dao.AlojamientoDAO;
import com.viagging.core.model.Alojamiento;
import com.viagging.core.model.CaracteristicaServicio;
import com.viagging.core.model.Servicio;
import com.viagging.core.services.AlojamientoService;
import com.viagging.core.services.CaracteristicaServicioService;
import com.viagging.core.services.ServicioService;
import com.viagging.rest.dto.AlojamientoDTO;
import com.viagging.rest.dto.CaracteristicaServicioDTO;
import com.viagging.rest.dto.CaracteristicasDTO;

@Service
public class AlojamientoServiceImpl implements AlojamientoService {

	@Autowired
	private AlojamientoDAO alojamientoDAO;
	
	@Autowired
	private ServicioService servicioService;
	
	@Autowired
	private CaracteristicaServicioService caracteristicaServicioService;
	
	@Override
	public Alojamiento getAlojamientoById(Integer idAlojamiento) {
		return alojamientoDAO.getAlojamientoById(idAlojamiento);
	}

	@Override
	public Alojamiento createAlojamiento(Alojamiento alojamiento) {
		return alojamientoDAO.createAlojamiento(alojamiento);
	}

	@Override
	public Alojamiento updateAlojamiento(Alojamiento alojamiento) {
		return alojamientoDAO.updateAlojamiento(alojamiento);
	}
	
	@Override
	public Alojamiento deleteAlojamiento(Integer idAlojamiento) {
		return alojamientoDAO.deleteAlojamiento(idAlojamiento);
	}
	
	@Override
	public Integer createAlojamiento(AlojamientoDTO alojamientoDTO) {
		Alojamiento alojamiento = buildAlojamiento(alojamientoDTO);
		alojamiento = createAlojamiento(alojamiento);
		Servicio servicio = servicioService.buildServicio(alojamientoDTO.getServicio());
		servicio.setAlojamiento(alojamiento);
		servicioService.createServicio(servicio);
		alojamientoDTO.getServicio().setId(servicio.getId());
		for (CaracteristicasDTO caracteristica : alojamientoDTO.getServicio().getCaracteristicas()) {
			caracteristica.setCategoria("ALOJAMIENTO");
			CaracteristicaServicioDTO ca = new CaracteristicaServicioDTO();
			ca.setCaracteristica(caracteristica);
			ca.setServicio(alojamientoDTO.getServicio());
			CaracteristicaServicio caracteristicaServicio = caracteristicaServicioService.buildCaracteristicaServicio(ca);
			caracteristicaServicioService.createCaracteristicaServicio(caracteristicaServicio);
		}
		return servicio.getId();
	}
	
	private Alojamiento buildAlojamiento(AlojamientoDTO alojamientoDTO) {
		Alojamiento alojamiento = new Alojamiento();
		alojamiento.setCiudad(alojamientoDTO.getCiudad());
		alojamiento.setNumeroPersonas(Integer.parseInt(alojamientoDTO.getNumeroPersonas()));
		alojamiento.setTipo(alojamientoDTO.getTipo());
		return alojamiento;
	}
}
