package com.viagging.core.services;

import com.viagging.core.model.Transaccion;

public interface TransaccionService {

	Transaccion getTransaccionById(Integer idTransaccion);

	Transaccion createTransaccion(Transaccion transaccion);

	Transaccion updateTransaccion(Transaccion transaccion);
	
}
