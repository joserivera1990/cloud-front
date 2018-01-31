package com.viagging.core.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.viagging.core.model.ListaDeseos;
import com.viagging.rest.dto.ListaDeseosDTO;

@Component
public class ListaDeseosMapper {
	
	@Autowired
	private PaqueteMapper paqueteMapper;
	
	@Autowired
	private ServicioMapper servicioMapper;
	
	public ListaDeseos mapObject(ListaDeseosDTO listaDeseosDTO) {
		ListaDeseos listaDeseos = new ListaDeseos();
		listaDeseos.setIdUsuario(listaDeseosDTO.getIdUsuario());
		if(listaDeseosDTO.getPaquete() != null){
			listaDeseos.setPaquete(paqueteMapper.mapObject(listaDeseosDTO.getPaquete()));
		}
		if(listaDeseosDTO.getServicio() != null){
			listaDeseos.setServicio(servicioMapper.mapObject(listaDeseosDTO.getServicio()));
		}
		
		return listaDeseos;
	}

	public List<ListaDeseos> mapObjectList(List<ListaDeseosDTO> listaDeseosDTO) {
		List<ListaDeseos> listaDeseos = new ArrayList<ListaDeseos>();
		for(ListaDeseosDTO listaDeseoDTO : listaDeseosDTO){
			listaDeseos.add(mapObject(listaDeseoDTO));
		}
		return listaDeseos;
	}
	
}
