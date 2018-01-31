package com.viagging.rest.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.viagging.core.mapper.IMapper;
import com.viagging.core.model.Orden;
import com.viagging.rest.dto.OrdenDTO;

@Component
public class OrdenDTOMapper implements IMapper<Orden, OrdenDTO>{

	@Autowired
	private TransaccionDTOMapper transaccionDTOMapper;
	
	@Autowired
	private CompraDTOMapper compraDTOMapper;
	
	@Override
	public OrdenDTO mapObject(Orden orden) {
		OrdenDTO ordenDTO = new OrdenDTO();
		ordenDTO.setId(orden.getId());
		ordenDTO.setEstado(orden.getEstado());
		ordenDTO.setFechaCompra(orden.getFechaCompra());
		ordenDTO.setTransaccion(transaccionDTOMapper.mapObject(orden.getTransaccion()));
		ordenDTO.setCompras(compraDTOMapper.mapObjectList(orden.getCompras()));
		return ordenDTO;
	}

	@Override
	public List<OrdenDTO> mapObjectList(List<Orden> ordenes) {
		List<OrdenDTO> ordenesDTO = new ArrayList<>();
		for(Orden orden : ordenes){
			OrdenDTO ordenDTO = mapObject(orden);
			ordenesDTO.add(ordenDTO);
		}
		return ordenesDTO;
	}

}
