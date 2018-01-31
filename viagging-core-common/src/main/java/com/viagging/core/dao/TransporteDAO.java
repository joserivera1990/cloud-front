package com.viagging.core.dao;

import com.viagging.core.model.Transporte;

public interface TransporteDAO {
  
	 Transporte getTransporteById(Integer idTransporte);

	 Transporte createTransporte( Transporte  transporte);

	 Transporte updateTransporte( Transporte  transporte);

	 Transporte deleteTransporte(Integer idTransporte);
}
