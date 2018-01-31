package com.viagging.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.core.dao.CompraDAO;
import com.viagging.core.model.Compra;
import com.viagging.core.services.CompraService;

@Service
public class CompraServiceImpl implements CompraService {

	@Autowired
	private CompraDAO compraDAO;
	
	@Override
	public Compra getCompraById(Integer idCompra) {
		return compraDAO.getCompraById(idCompra);
	}

	@Override
	public Compra createCompra(Compra compra) {
		return compraDAO.createCompra(compra);
	}

}
