package com.viagging.core.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viagging.core.dao.PaseoEcologicoDAO;
import com.viagging.core.model.CaracteristicaServicio;
import com.viagging.core.model.PaseoEcologico;
import com.viagging.core.model.Servicio;
import com.viagging.core.services.CaracteristicaServicioService;
import com.viagging.core.services.PaseoEcologicoService;
import com.viagging.core.services.ServicioService;
import com.viagging.rest.dto.CaracteristicaServicioDTO;
import com.viagging.rest.dto.CaracteristicasDTO;
import com.viagging.rest.dto.PaseoEcologicoDTO;

@Service
public class PaseoEcologicoServiceImpl implements PaseoEcologicoService {

	@Autowired
	private PaseoEcologicoDAO paseoEcologicoDAO;
	
	@Autowired
	private ServicioService servicioService;
	
	@Autowired
	private CaracteristicaServicioService caracteristicaServicioService;
	
	@Override
	public PaseoEcologico getPaseoEcologicoById(Integer idPaseoEcologico) {
		return paseoEcologicoDAO.getPaseoEcologicoById(idPaseoEcologico);
	}

	@Override
	public PaseoEcologico createPaseoEcologico(PaseoEcologico paseoEcologico) {
		return paseoEcologicoDAO.createPaseoEcologico(paseoEcologico);
	}

	@Override
	public 	PaseoEcologico updatePaseoEcologico(PaseoEcologico paseoEcologico){
		return paseoEcologicoDAO.updatePaseoEcologico(paseoEcologico);
	}
	
	@Override
	public PaseoEcologico deletePaseoEcologico(Integer idPaseoEcologico) {
		return paseoEcologicoDAO.deletePaseoEcologico(idPaseoEcologico);
	}

	@Override
	public Integer createPaseoEcologico(PaseoEcologicoDTO paseoEcologicoDTO) {
		PaseoEcologico paseoEcologico = buildPaseoEcologico(paseoEcologicoDTO);
		createPaseoEcologico(paseoEcologico);
		Servicio servicio = servicioService.buildServicio(paseoEcologicoDTO.getServicio());
		servicio.setPaseoEcologico(paseoEcologico);
		servicioService.createServicio(servicio);
		paseoEcologicoDTO.getServicio().setId(servicio.getId());
		for (CaracteristicasDTO caracteristica : paseoEcologicoDTO.getServicio().getCaracteristicas()) {
			caracteristica.setCategoria("PASEOECOLOGICO");
			CaracteristicaServicioDTO ca = new CaracteristicaServicioDTO();
			ca.setCaracteristica(caracteristica);
			ca.setServicio(paseoEcologicoDTO.getServicio());
			CaracteristicaServicio caracteristicaServicio = caracteristicaServicioService.buildCaracteristicaServicio(ca);
			caracteristicaServicioService.createCaracteristicaServicio(caracteristicaServicio);
		}
		return servicio.getId();
	}
	
	private PaseoEcologico buildPaseoEcologico(PaseoEcologicoDTO paseoEcologicoDTO) {
		PaseoEcologico paseoEcologico = new PaseoEcologico();
		paseoEcologico.setCiudad(paseoEcologicoDTO.getCiudad());
		paseoEcologico.setHorario(paseoEcologicoDTO.getHorario());
		paseoEcologico.setTiempoderecorrido(paseoEcologicoDTO.getTiempoDeRecorrido());
		return paseoEcologico;
	}
	
}
