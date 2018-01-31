package com.viagging.api.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.viagging.api.model.Deseo;
import com.viagging.core.model.ListaDeseos;
import com.viagging.rest.dto.PaqueteDTO;
import com.viagging.rest.dto.ProductoDTO;
import com.viagging.rest.dto.ServicioDTO;
import com.viagging.rest.dto.mapper.PaqueteDTOMapper;
import com.viagging.rest.dto.mapper.ProductoDTOMapper;
import com.viagging.rest.dto.mapper.ServicioDTOMapper;

@Component
public class DeseoMapper {
	
	@Autowired
	private ServicioDTOMapper servicioDTOMapper;
	
	@Autowired
	private PaqueteDTOMapper paqueteDTOMapper;
	
	@Autowired
	private ProductoDTOMapper productoMapper;
	
	public Deseo mapObject(ListaDeseos listaDeseo){
		Deseo deseo = new Deseo();
		deseo.setId(listaDeseo.getId());
		
		ProductoDTO producto = null;
		
		if(listaDeseo.getServicio() != null){
			ServicioDTO servicio = servicioDTOMapper.mapObject(listaDeseo.getServicio());
			producto = productoMapper.buildProductoFromServicio(servicio);
		} else if (listaDeseo.getPaquete() != null){
			PaqueteDTO paquete = paqueteDTOMapper.mapObject(listaDeseo.getPaquete());
			producto = productoMapper.buildProductoFromPaquete(paquete);
		}
		
		deseo.setProducto(producto);
		return deseo;
	}
	
	public List<Deseo> mapObjectList(List<ListaDeseos> listaDeseos){
		List<Deseo> deseos = new ArrayList<>();
		for(ListaDeseos listaDeseo : listaDeseos){
			deseos.add(mapObject(listaDeseo));
		}
		return deseos;
	}
	
}
