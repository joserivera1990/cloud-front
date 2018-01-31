package com.viagging.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.api.model.Deseo;
import com.viagging.api.model.mapper.DeseoMapper;
import com.viagging.core.model.mapper.ListaDeseosMapper;
import com.viagging.core.services.ListaDeseosService;
import com.viagging.rest.dto.ListaDeseosDTO;

@RestController
@RequestMapping("/wishList")
public class ListaDeseosController {

	public static final String SERVICE_ERROR_MESSAGE_NOT_FOUND = "Lista de Deseos no encontrados";
	
	@Autowired
	private ListaDeseosService listaDeseosService;
	
	@Autowired
	private DeseoMapper deseoMapper;
	
	@Autowired
	private ListaDeseosMapper listaDeseosMapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Deseo> getListaDeseos(){
		return deseoMapper.mapObjectList(listaDeseosService.getAllListaDeseos());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void addListaDeseos(@RequestBody ListaDeseosDTO listaDeseosDTO){
		listaDeseosService.createListaDeseos(listaDeseosMapper.mapObject(listaDeseosDTO));
	}
}
