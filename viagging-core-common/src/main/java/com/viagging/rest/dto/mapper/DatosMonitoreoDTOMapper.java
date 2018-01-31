package com.viagging.rest.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.viagging.rest.dto.DatosMonitoreoDTO;

@Component
public class DatosMonitoreoDTOMapper {

	public List<DatosMonitoreoDTO>  mapObject(List<Object[]> listData ) {
		List<DatosMonitoreoDTO> listMonitoreo = new ArrayList<>();
        for (Object[] objectData : listData) {
      	    DatosMonitoreoDTO datos = new DatosMonitoreoDTO();
      	    datos.setTipo(objectData[0].toString());
      	    datos.setNombre(objectData[1].toString());
      	    datos.setFechaVenta(objectData[2].toString());
      	    datos.setCantidad(objectData[3].toString());
            listMonitoreo.add(datos);
		}
        return listMonitoreo;       
    }
	
}
