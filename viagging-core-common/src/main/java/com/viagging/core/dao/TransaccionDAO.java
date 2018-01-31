package com.viagging.core.dao;

import com.viagging.core.model.Transaccion;

public interface TransaccionDAO {

	Transaccion getTransaccionById(Integer idTransaccion);

	Transaccion createTransaccion(Transaccion transaccion);

	Transaccion updateTransaccion(Transaccion transaccion);

}
