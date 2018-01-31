package com.viagging.rest.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.viagging.core.model.ListaDeseos;
import com.viagging.rest.dto.ListaDeseosDTO;
import com.viagging.rest.dto.ServicioDTO;

@Component
public class ListaDeseosDTOMapper {
	
	@Autowired
	private PaqueteDTOMapper paqueteDTOMapper;

	public ListaDeseosDTO mapObject(ListaDeseos listaDeseos){
		ListaDeseosDTO listaDeseosDTO = new ListaDeseosDTO();
		listaDeseosDTO.setId(Integer.valueOf(listaDeseos.getId()));
		listaDeseosDTO.setIdUsuario(Integer.valueOf(listaDeseos.getIdUsuario()));
		if(listaDeseos.getServicio() != null){
			listaDeseosDTO.setServicio(ServicioDTO.buildObject(listaDeseos.getServicio()));
		}
		if(listaDeseos.getPaquete() != null){
			listaDeseosDTO.setPaquete(paqueteDTOMapper.mapObject(listaDeseos.getPaquete()));
		}
		return listaDeseosDTO;
	}
	
	public List<ListaDeseosDTO> mapObjectList(List<ListaDeseos> listaDeseos){
		List<ListaDeseosDTO> listaDeseosDTO = new ArrayList<>();
		for(ListaDeseos listaDeseo : listaDeseos){
			ListaDeseosDTO listaDeseoDTO = mapObject(listaDeseo);
			listaDeseosDTO.add(listaDeseoDTO);
		}
		return listaDeseosDTO;
	} 
	
}
