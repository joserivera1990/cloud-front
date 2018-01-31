package com.viagging.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viagging.core.dao.CaracteristicaDAO;
import com.viagging.core.model.Caracteristica;
import com.viagging.core.services.CaracteristicaService;


@Service
public class CaracteristicaServiceImpl implements CaracteristicaService  {

	
	@Autowired
	private CaracteristicaDAO caracteristicaDAO;

	@Override
	public List<Caracteristica> getCaracteristicaByCategoria(String categoria) {
		return caracteristicaDAO.getCaracteristicasByCategoria(categoria);
	}

}
