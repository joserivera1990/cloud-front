package com.viagging.core.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.core.constant.EstadoItem;
import com.viagging.core.dao.ServicioDAO;
import com.viagging.core.dao.UsuarioDAO;
import com.viagging.core.model.Servicio;
import com.viagging.core.model.Usuario;
import com.viagging.core.services.ServicioService;
import com.viagging.rest.dto.ServicioDTO;
import com.viagging.util.CategoryEnum;

@Service
public class ServicioServiceImpl implements ServicioService {
	
	@Autowired
	private ServicioDAO servicioDAO;
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Override
	public Servicio getServicioById(Integer idServicio) {
		return servicioDAO.getServicioById(idServicio);
	}
  
	@Override
	public List<Servicio> getAllServicio() {
		return servicioDAO.getAllServicios();
	}

	@Override
	public Servicio createServicio(Servicio servicio) {
		return servicioDAO.createServicio(servicio);
	}

	@Override
	public Servicio updateServicio(Servicio servicio) {
		return servicioDAO.updateServicio(servicio);
	}
    
	@Override
	public List<Servicio> getAllServiciosByCategoria(String idCategoria) {
		
		if(CategoryEnum.ALIMENTACION.getId().equals(idCategoria)){
			return servicioDAO.getAllServiciosAlimentacion();			
		} else if(CategoryEnum.ALOJAMIENTO.getId().equals(idCategoria)){
			return servicioDAO.getAllServiciosAlojamiento();
		} else if(CategoryEnum.PASEO_ECOLOGICO.getId().equals(idCategoria)){
			return servicioDAO.getAllServiciosPaseoEcologico();
		} else if(CategoryEnum.TRANSPORTE.getId().equals(idCategoria)){
			return servicioDAO.getAllServiciosTransporte();
		} else {
			return servicioDAO.getAllServicios();
		}
	}
	
	@Override
	public List<Servicio> buildListServices(List<ServicioDTO> listServiceDTO) {
		List<Servicio> listServicio = new ArrayList<>();
		for (ServicioDTO servicioDTO : listServiceDTO) {
			Servicio servicio = new Servicio();
			servicio.setId(servicioDTO.getId());
			listServicio.add(servicio);
		}
		return listServicio;
	}
	
	@Override
	public Servicio buildServicio(ServicioDTO servicioDTO) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Servicio servicio = new Servicio();
		servicio.setRestricciones(servicioDTO.getRestricciones());
		servicio.setActivo(servicioDTO.getActivo());
		servicio.setPrecio(Integer.parseInt(servicioDTO.getPrecio()));
		if (servicioDTO.getActivo()) {
			servicio.setEstado(EstadoItem.ACTIVO.getId());
		} else {
			servicio.setEstado(EstadoItem.INACTIVO.getId());
		}
		try {
			servicio.setFechaInicio(sdf.parse(servicioDTO.getFechaInicial()));
			servicio.setFechaVigencia(sdf.parse(servicioDTO.getFechaFinal()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		servicio.setCapacidad(Integer.parseInt(servicioDTO.getCapacidad()));
		Usuario usuario = usuarioDAO.getUsuarioById(Integer.parseInt(servicioDTO.getUsuario().getId()));
		servicio.setUsuario(usuario);
		servicio.setDescripcion(servicioDTO.getDescripcionCorta());
		servicio.setNombre(servicioDTO.getNombre());
		return servicio;
	}

	@Override
	public List<Servicio> findAllByCriteria(Servicio servicio) {
		return servicioDAO.findAllByCriteria(servicio);
	}

	@Override
	public void activarServicio(Servicio servicio) {
		servicioDAO.activarServicio(servicio);
		
	}

	@Override
	public void deleteServicio(Integer idServicio) {
		servicioDAO.deleteServicio(idServicio);
	}
	
	@Override
	public List<Servicio> getServiciosByCategoriaProveedor(String idCategoria,String idProveedor) {
		
		if(CategoryEnum.ALIMENTACION.getId().equals(idCategoria)){
			return servicioDAO.getServiciosAlimentacionByProveedor(NumberUtils.toInt(idProveedor));		
		} else if(CategoryEnum.ALOJAMIENTO.getId().equals(idCategoria)){
			return servicioDAO.getServiciosAlojamientoByProveedor(NumberUtils.toInt(idProveedor));
		} else if(CategoryEnum.PASEO_ECOLOGICO.getId().equals(idCategoria)){
			return servicioDAO.getServiciosPaseoEcologicoByProveedor(NumberUtils.toInt(idProveedor));
		} else if(CategoryEnum.TRANSPORTE.getId().equals(idCategoria)){
			return servicioDAO.getServiciosTransporteByProveedor(NumberUtils.toInt(idProveedor));
		} else {
			return servicioDAO.getAllServiciosByProveedor(NumberUtils.toInt(idProveedor));
		}
	}
}
