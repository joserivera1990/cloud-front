package com.viagging.core.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.core.services.MovimientoService;
import com.viagging.core.services.PaqueteService;
import com.viagging.core.services.ServicioService;
import com.viagging.core.dao.MovimientoDAO;
import com.viagging.core.model.Paquete;
import com.viagging.core.model.Servicio;
import com.viagging.core.model.Usuario;
import com.viagging.core.model.mapper.MovimientoMapper;
import com.viagging.core.services.UsuarioService;
import com.viagging.rest.dto.DatosMonitoreoDTO;
import com.viagging.rest.dto.mapper.DatosMonitoreoDTOMapper;

@Service
public class MovimientoServiceImpl implements  MovimientoService{
	
	@Autowired
	private MovimientoMapper<Serializable> movimientoMapper;
	
	@Autowired
	private MovimientoDAO movimientoDAO;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private DatosMonitoreoDTOMapper datosMonitoreoDTOMapper;
	
	@Autowired
	private PaqueteService paqueteService;
	
	@Autowired
	private ServicioService servicioService;
	
	private ExecutorService executorService;
	
	
	@PostConstruct
    public void init() {
        executorService = Executors.newCachedThreadPool();
    }
	
	@Override
	public List<Object[]> findInfoReport(String query){
		return movimientoDAO.findInfoReport(query);
	}
	
	@Override
	public void createMovimientos(final List<String> listServicios,final List<String> listPaquetes,final String idUsuario,final String tipo ){
		executorService.submit(new Callable<Object>() {
                public Object call() throws Exception {
                	ejecutarProceso(listServicios, listPaquetes, idUsuario, tipo);
                    return null;
                }
	        });			
	}
    	
	private void ejecutarProceso(final List<String> listServicios,final List<String> listPaquetes,final String idUsuario,final String tipo){
		Usuario usuario = null;
		if(idUsuario != null && !idUsuario.equals("")){
			usuario = usuarioService.getUsuarioById(Integer.valueOf(idUsuario));
		}
		if(listPaquetes  != null){
			for (String idPaquete : listPaquetes) {				
				movimientoDAO.createMovimiento(movimientoMapper.mapObject(paqueteService.getPaqueteById(Integer.valueOf(idPaquete)), usuario, tipo));
			}
		}
		if(listServicios != null){
			for (String idServicio : listServicios) {
				movimientoDAO.createMovimiento(movimientoMapper.mapObject(servicioService.getServicioById(Integer.valueOf(idServicio)) , usuario, tipo));
			}
		}
	}
	
	@Override
	public List<DatosMonitoreoDTO> findInfoMonitorero(String fechaInicial, String fechaFinal){
		List<Object[]> listObject = movimientoDAO.findInfoReport(buildQuery(fechaInicial, fechaFinal));
		return datosMonitoreoDTOMapper.mapObject(listObject);
	}
	
    private String buildQuery(String fechaInicial, String fechaFinal){
    	StringBuilder queryString = new StringBuilder();
		queryString.append("select case when com.idservicio IS NULL then 'Paquete' else 'Servicio' END as tipo, ");
		queryString.append("case when com.idservicio IS NULL then paq.nombrepaquete else serv.nombre END as nombre, ");
		queryString.append("ord.fechacompra as fechacompra,  ");
		queryString.append("com.cantidad as cantidad  ");
		queryString.append(" from tp_compra as com ");
		queryString.append("INNER JOIN tp_orden as ord ON com.idorden = ord.id ");
		queryString.append("LEFT JOIN tp_servicio as serv ON com.idservicio = serv.id ");			
		queryString.append("LEFT JOIN tp_paquete as paq ON com.idpaquete = paq.id ");
		if(fechaInicial != null && !fechaInicial.equals("")){
			queryString.append("where (ord.fechacompra BETWEEN '" +fechaInicial + "' and '" + fechaFinal + "')  ");
		}
		
		queryString.append("ORDER BY ord.fechacompra ASC ");
		
		return queryString.toString();
    }
}