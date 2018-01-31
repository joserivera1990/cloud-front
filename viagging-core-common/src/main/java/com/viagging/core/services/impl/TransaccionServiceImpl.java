package com.viagging.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.core.dao.TransaccionDAO;
import com.viagging.core.model.Transaccion;
import com.viagging.core.services.TransaccionService;

@Service
public class TransaccionServiceImpl implements TransaccionService {

	@Autowired
	private TransaccionDAO transaccionDAO;
	
	@Override
	public Transaccion getTransaccionById(Integer idTransaccion) {
		return transaccionDAO.getTransaccionById(idTransaccion);
	}

	@Override
	public Transaccion createTransaccion(Transaccion transaccion) {
		return transaccionDAO.createTransaccion(transaccion);
	}

	@Override
	public Transaccion updateTransaccion(Transaccion transaccion) {
		return transaccionDAO.updateTransaccion(transaccion);
	}

}
