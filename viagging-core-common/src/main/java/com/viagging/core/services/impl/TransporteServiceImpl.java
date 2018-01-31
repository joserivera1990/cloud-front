package com.viagging.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.core.dao.TransporteDAO;
import com.viagging.core.model.CaracteristicaServicio;
import com.viagging.core.model.Servicio;
import com.viagging.core.model.Transporte;
import com.viagging.core.services.CaracteristicaServicioService;
import com.viagging.core.services.ServicioService;
import com.viagging.core.services.TransporteService;
import com.viagging.rest.dto.CaracteristicaServicioDTO;
import com.viagging.rest.dto.CaracteristicasDTO;
import com.viagging.rest.dto.TransporteDTO;

@Service
public class TransporteServiceImpl implements TransporteService {

	@Autowired
	private TransporteDAO transporteDAO;

	@Autowired
	private ServicioService servicioService;
	
	@Autowired
	private CaracteristicaServicioService caracteristicaServicioService;
	
	@Override
	public Transporte getTransporteById(Integer idTransporte) {
		return transporteDAO.getTransporteById(idTransporte);
	}

	@Override
	public Transporte createTransporte(Transporte transporte) {
		return transporteDAO.createTransporte(transporte);
	}

	@Override
	public 	Transporte updateTransporte(Transporte transporte){
		return transporteDAO.updateTransporte(transporte);
	}
	
	@Override
	public Transporte deleteTransporte(Integer idTransporte) {
		return transporteDAO.deleteTransporte(idTransporte);
	}

	@Override
	public Integer createTransporte(TransporteDTO transporteDTO) {
		Transporte transporte = buildTransporte(transporteDTO);
		createTransporte(transporte);
		Servicio servicio = servicioService.buildServicio(transporteDTO.getServicio());
		servicio.setTransporte(transporte);
		servicioService.createServicio(servicio);
		transporteDTO.getServicio().setId(servicio.getId());
		for (CaracteristicasDTO caracteristica : transporteDTO.getServicio().getCaracteristicas()) {
			caracteristica.setCategoria("TRANSPORTE");
			CaracteristicaServicioDTO ca = new CaracteristicaServicioDTO();
			ca.setCaracteristica(caracteristica);
			ca.setServicio(transporteDTO.getServicio());
			CaracteristicaServicio caracteristicaServicio = caracteristicaServicioService.buildCaracteristicaServicio(ca);
			caracteristicaServicioService.createCaracteristicaServicio(caracteristicaServicio);
		}
		return servicio.getId();
		
	}
	
	private Transporte buildTransporte(TransporteDTO transporteDTO) {
		Transporte transporte = new Transporte();
		transporte.setFrecuenciasalida(transporteDTO.getFrecuenciaSalida());
		transporte.setHorariofin(transporteDTO.getHorarioFin());
		transporte.setHorarioinicio(transporteDTO.getHorarioInicio());
		transporte.setLugardestino(transporteDTO.getLugarDestino());
		transporte.setLugarorigen(transporteDTO.getLugarOrigen());
		transporte.setTiempoestimado(transporteDTO.getTiempoEstimado());
		transporte.setTipotransporte(transporteDTO.getTipoTransporte());
		return transporte;
	}

}
