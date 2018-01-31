package com.viagging.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.core.dao.CaracteristicaDAO;
import com.viagging.core.dao.CaracteristicaServicioDAO;
import com.viagging.core.dao.ServicioDAO;
import com.viagging.core.model.Caracteristica;
import com.viagging.core.model.CaracteristicaServicio;
import com.viagging.core.model.Servicio;
import com.viagging.core.services.CaracteristicaServicioService;
import com.viagging.rest.dto.CaracteristicaServicioDTO;


@Service
public class CaracteristicaServicioServiceImpl implements CaracteristicaServicioService  {

	
	@Autowired
	private CaracteristicaServicioDAO caracteristicaServicioDAO;
	
	@Autowired
	private CaracteristicaDAO caracteristicaDAO;
	
	@Autowired
	private ServicioDAO servicioDAO;
	
	@Override
	public CaracteristicaServicio createCaracteristicaServicio(CaracteristicaServicio caracteristicaServicio) {
		return caracteristicaServicioDAO.createCaracteristicaServicio(caracteristicaServicio);
		
	}

	@Override
	public void createCaracteristicaServicio(CaracteristicaServicioDTO caracteristicaServicioDTO) {
		CaracteristicaServicio caracteristicaServicio = buildCaracteristicaServicio(caracteristicaServicioDTO);
		createCaracteristicaServicio(caracteristicaServicio);
		
	}
	
	@Override
	public CaracteristicaServicio buildCaracteristicaServicio(CaracteristicaServicioDTO caracteristicaServicioDTO) {
		CaracteristicaServicio cs = new CaracteristicaServicio();
		Caracteristica c = caracteristicaDAO.getCaracteristicaByCtgAndCars(caracteristicaServicioDTO.getCaracteristica().getCategoria(), caracteristicaServicioDTO.getCaracteristica().getValor());
		Servicio s = servicioDAO.getServicioById(caracteristicaServicioDTO.getServicio().getId());
		cs.setCaracteristica(c);
		cs.setServicio(s);
		return cs;
	}

}
