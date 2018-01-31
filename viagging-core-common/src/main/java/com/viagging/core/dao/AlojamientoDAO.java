package com.viagging.core.dao;

import com.viagging.core.model.Alojamiento;

public interface AlojamientoDAO {
   
	Alojamiento getAlojamientoById(Integer idAlojamiento);

	Alojamiento createAlojamiento(Alojamiento alojamiento);

	Alojamiento updateAlojamiento(Alojamiento alojamiento);

	Alojamiento deleteAlojamiento(Integer idAlojamiento);
}
