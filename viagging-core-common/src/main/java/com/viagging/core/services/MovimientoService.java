package com.viagging.core.services;

import java.util.List;

import com.viagging.core.model.Paquete;
import com.viagging.core.model.Servicio;
import com.viagging.rest.dto.DatosMonitoreoDTO;

public interface MovimientoService {
     
	List<Object[]> findInfoReport(String query);
    
	void createMovimientos(List<String> listServicios,List<String> listPaquetes, String idUsuario,String tipo );
	
	List<DatosMonitoreoDTO> findInfoMonitorero(String fechaInicial, String fechaFinal);
}