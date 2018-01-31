package com.viagging.core.dao;

import com.viagging.core.model.Compra;

public interface CompraDAO {

	Compra getCompraById(Integer idCompra);

	Compra createCompra(Compra compra);

}
