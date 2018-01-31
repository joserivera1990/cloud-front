package com.viagging.core.dao;

import java.util.List;

import com.viagging.core.model.Movimiento;

public interface MovimientoDAO {
	
	List<Object[]> findInfoReport(String query);
    
	Movimiento createMovimiento(Movimiento movimiento);
}

