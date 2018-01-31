package com.viagging.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.core.dao.OrdenDAO;
import com.viagging.core.model.Orden;
import com.viagging.core.services.OrdenService;

@Service
public class OrdenServiceImpl implements OrdenService {

	@Autowired
	private OrdenDAO ordenDAO;
	
	@Override
	public List<Orden> getAllOrdenes() {
		return ordenDAO.getAllOrdenes();
	}

	@Override
	public List<Orden> getOrdenesByUsuario(Integer idUsuario) {
		return ordenDAO.getOrdenesByUsuario(idUsuario);
	}

	@Override
	public Orden getOrdenById(Integer idOrden) {
		return ordenDAO.getOrdenById(idOrden);
	}

	@Override
	public Orden createOrden(Orden orden) {
		return ordenDAO.createOrden(orden);
	}

	@Override
	public Orden updateOrden(Orden orden) {
		return ordenDAO.updateOrden(orden);
	}

}
