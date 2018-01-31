package com.viagging.core.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.core.constant.EstadoItem;
import com.viagging.core.dao.PaqueteDAO;
import com.viagging.core.dao.PaqueteServicioDAO;
import com.viagging.core.dao.ServicioDAO;
import com.viagging.core.dao.UsuarioDAO;
import com.viagging.core.model.Paquete;
import com.viagging.core.model.PaqueteServicio;
import com.viagging.core.model.Servicio;
import com.viagging.core.model.Usuario;
import com.viagging.core.services.PaqueteService;
import com.viagging.rest.dto.PaqueteDTO;

@Service
public class PaqueteServiceImpl implements PaqueteService{

	@Autowired
	private PaqueteDAO paqueteDAO;
	
	@Autowired
	private ServicioDAO servicioDAO;
	
	@Autowired
	private PaqueteServicioDAO paqueteServicioDAO;
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public Paquete getPaqueteById(Integer idPaquete) {
		return paqueteDAO.getPaqueteById(idPaquete);
	}

	@Override
	public List<Paquete> getAllPaquete() {
		return paqueteDAO.getAllPaquetes();
	}

	@Override
	public Paquete createPaquete(Paquete paquete,List<Servicio> listaServicio,String idUsuario) {
		Usuario usuario = usuarioDAO.getUsuarioById(Integer.valueOf(idUsuario));  
		paquete.setUsuario(usuario);
		paquete.setId(null);
        Paquete paqueteCreado =	paqueteDAO.createPaquete(paquete);
        for (Servicio servicio : listaServicio) {
        	Servicio service = servicioDAO.getServicioById(servicio.getId());
        	PaqueteServicio paqueteServicio = new PaqueteServicio();
        	paqueteServicio.setPaquete(paqueteCreado);
        	paqueteServicio.setServicio(service);
        	paqueteServicioDAO.createPaqueteServicio(paqueteServicio);
		}       
	
	return paqueteCreado;
	}

	@Override
	public Paquete updatePaquete(Paquete paquete) {
		return paqueteDAO.updatePaquete(paquete);
	}
	
	@Override
	public Paquete buildPaquete(PaqueteDTO paqueteDTO) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Paquete paquete = null;
		try {
			paquete = new Paquete(paqueteDTO.getId(),  paqueteDTO.getNombre(), Integer.valueOf(paqueteDTO.getPrecio()),
					paqueteDTO.getDescripcion(),sdf.parse(paqueteDTO.getFechaInicial()), sdf.parse(paqueteDTO.getFechaInicial()), Integer.valueOf(paqueteDTO.getCapacidad()));
			paquete.setEstado(paqueteDTO.getActivo() ? EstadoItem.ACTIVO.getId() : EstadoItem.INACTIVO.getId() );
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		return paquete;
	}
	
	@Override
	public List<Paquete> getAllPaquetesByFiltro(String filtro,int idUsuario){
		return paqueteDAO.getAllPaquetesByFiltro(filtro, idUsuario);
	}

	@Override
	public List<Paquete> findAllByCriteria(Paquete paquete) {
		return paqueteDAO.findAllByCriteria(paquete);
	}
	
	@Override
	public Paquete activatePaquete(Paquete paquete){
		  return paqueteDAO.activatePaquete(paquete);
	}
	
	@Override
	public void deletePaquete(Integer idPaquete){
		paqueteDAO.deletePaquete(idPaquete);
	}
}

