package com.viagging.core.dao;

import java.util.List;
import com.viagging.core.model.Servicio;
import com.viagging.rest.dto.ServicioDTO;

/**
 * The Interface ServicioDAO.
 */
public interface ServicioDAO {


	Servicio getServicioById(Integer idServicio);

	List<Servicio> getAllServicios();
	
	List<Servicio> getAllServiciosTransporte();
	
	List<Servicio> getAllServiciosAlojamiento();
	
	List<Servicio> getAllServiciosAlimentacion();
	
	List<Servicio> getAllServiciosPaseoEcologico();

	Servicio createServicio(Servicio servicio);

	Servicio updateServicio(Servicio servicio);

	Servicio deleteServicio(Integer idServicio);
	
	Servicio servicioDTOToModel(ServicioDTO servicio);
	
	List<Servicio> findAllByCriteria(Servicio servicio);

	void activarServicio(Servicio servicio);
	
	List<Servicio> getServiciosTransporteByProveedor(int idUsuario);
	
	List<Servicio> getServiciosAlimentacionByProveedor(int idUsuario);
	
	List<Servicio> getServiciosAlojamientoByProveedor(int idUsuario);
	
	List<Servicio> getServiciosPaseoEcologicoByProveedor(int idUsuario);
	
	List<Servicio> getAllServiciosByProveedor(int idUsuario);
	
	
}
