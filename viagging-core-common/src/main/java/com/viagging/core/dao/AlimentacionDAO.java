package com.viagging.core.dao;

import com.viagging.core.model.Alimentacion;


public interface AlimentacionDAO {

	Alimentacion getAlimentacionById(Integer idAlimentacion);

	Alimentacion createAlimentacion(Alimentacion alimentacion);

	Alimentacion updateAlimentacion(Alimentacion alimentacion);

	Alimentacion deleteAlimentacion(Integer idAlimentacion);
	
}
