package com.viagging.core.services;

import com.viagging.core.model.Compra;

public interface CompraService {

	Compra getCompraById(Integer idCompra);

	Compra createCompra(Compra compra);
	
}
